package com.mycompany.myapp.common.component.processor;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.ImageIcon;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.component.vo.AttachmentVO;
import com.mycompany.myapp.common.util.ThumbnailUtil;

@Service
public class AttachmentProcessor {

    private @Value("${upload.path}") String uploadRootPath;

    private static final Logger LOG = LoggerFactory.getLogger(AttachmentProcessor.class);

    /**
     * 업로드할 파일 타입을 정의
     */
    private @Value("${upload.file.type}") String uploadFileType;

    public AttachmentVO upload(String serviceId, MultipartFile multipartFile) throws IllegalStateException, IOException  {
        return upload(serviceId, multipartFile, false, "");
    }

    public AttachmentVO upload(String serviceId, MultipartFile multipartFile, boolean isExt) throws IllegalStateException, IOException  {
        return upload(serviceId, multipartFile, isExt, "");
    }

    public AttachmentVO uploadImage(String serviceId, MultipartFile multipartFile) throws IllegalStateException, IOException  {
        return upload(serviceId, multipartFile, false, "jpg|gif|bmp|png");
    }

    public AttachmentVO uploadImage(String serviceId, MultipartFile multipartFile, boolean isExt) throws IllegalStateException, IOException  {
        return upload(serviceId, multipartFile, isExt, "jpg|gif|bmp|png");
    }

    public AttachmentVO upload(String serviceId, MultipartFile multipartFile, boolean isExt, String extMatch) throws IllegalStateException, IOException  {

        LOG.debug("invoked 'upload' method...");

        //인자값검증 추가 : 2011-04-20
        if(StringUtils.isEmpty(serviceId) ||  multipartFile==null || multipartFile.getSize()==0){
            return null;
        }

        String ext = "";
        if (isExt) {
            LOG.debug("getName ========== " + multipartFile.getName());
            LOG.debug("getOriginalFilename ========== " + multipartFile.getOriginalFilename());
            String fileNmae = multipartFile.getOriginalFilename();
            ext = FilenameUtils.getExtension(fileNmae);
            //int extPoint = fileNmae.lastIndexOf(".");
            //ext = StringUtils.substring(fileNmae, extPoint + 1, fileNmae.length());

            LOG.debug("ext ========== " + ext);
            //파일확장자처리부분
            if (extMatch == null || "".equals(extMatch)) {
                extMatch = this.uploadFileType;
            }
            if(ext.matches("(?i)^[ \\w\uAC00-\uD7A3]+\\.(" + extMatch + ")$")){
                return null;
            }
        }

        LOG.debug("getContentType ========== " + multipartFile.getContentType());
        //jpg|gif|bmp|png|doc|pdf|ppt|txt|xls|zip
        if(!StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "image") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "text") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/msword") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/pdf") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/vnd.ms-powerpoint") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/vnd.ms-excel") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/vnd.openxmlformats-officedocument") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/haansofthwp") &&
            !StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "application/zip")) {
            return null;
        }

        long systemCurrTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd");
        String dateDir = formatter.format(systemCurrTime);

        String filePath = this.uploadRootPath + "/" + serviceId + "/" + dateDir;
        String fileName = "";
        if (isExt || "".equals(ext))    {
            fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString();
        } else {
            fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString() + "." + ext;
        }

        File fileDir = new File(filePath);
        if( !fileDir.exists() ){
            fileDir.mkdirs();
        }

        File uploadFile = new File(fileDir, fileName);
        multipartFile.transferTo(uploadFile);

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setOriginalFilename(multipartFile.getOriginalFilename());
        attachmentVO.setContentType(multipartFile.getContentType());
        attachmentVO.setFileName(fileName);
        attachmentVO.setFilePath(filePath);
        attachmentVO.setFileSize(multipartFile.getSize());
        attachmentVO.setExtension(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));

        int imageWidth=0;
        int imageHeight=0;
        if(StringUtils.startsWithIgnoreCase(multipartFile.getContentType(), "image")){
            //이미지일경우에
            Image image = new ImageIcon(uploadFile.getAbsolutePath()).getImage();
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);
        }

        attachmentVO.setImageWidth(imageWidth);
        attachmentVO.setImageHeight(imageHeight);

        return attachmentVO;
    }

    /**
     * 이미지 url명으로 실제 서버위치의 파일을 가져옮
     * @param imageId
     * @return
     */
    public AttachmentVO getImage(String imageId) {
        //인자값검증 추가 : 2011-04-20
        if(StringUtils.isEmpty(imageId)){
            return null;
        }

        imageId = imageId.replaceAll("\\..\\/", "");
        imageId = imageId.replaceAll("\\.\\/", "");
        imageId = imageId.replaceAll(".*\\.\\./.*","");


        String[] imageIds = StringUtils.split(imageId, Constants.FILE_NAME_DECIMAL);
        if(imageIds.length != 3){
            return null;
        }

        String serviceId = imageIds[0];
        String dateDir = imageIds[1];
        String originalFilename = imageId;

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setFilePath(this.uploadRootPath + "/" + serviceId + "/" + dateDir);
        attachmentVO.setOriginalFilename(originalFilename);

        return attachmentVO;
    }

    /**
     * 서버에 있는 파일을 다른 위치로 이동
     * @param serviceId
     * @param moveId
     * @param arrFile
     * @return
     */
    public AttachmentVO getMoveFile(String serviceId, String moveId, String arrFile) {
        String[] fileInfo = arrFile.split("\\|");
        String[] filePath = fileInfo[1].split(Constants.FILE_NAME_DECIMAL);
        File file = new File(
                            this.uploadRootPath
                            + File.separator
                            + filePath[0]
                            + File.separator
                            + filePath[1]
                            + File.separator
                            + fileInfo[1]);
        File new_fileDir = new File(
                this.uploadRootPath
                + File.separator
                + serviceId
                + File.separator
                + filePath[1]
        );

        if( !new_fileDir.exists() ){
            new_fileDir.mkdirs();
        }

        file.renameTo(
                new File(
                this.uploadRootPath
                + File.separator
                + serviceId
                + File.separator
                + filePath[1]
                + File.separator
                + fileInfo[1].replace(moveId, serviceId)
                )
        );

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setOriginalFilename(fileInfo[2]);
        attachmentVO.setFileName(fileInfo[1].replace(moveId, serviceId));
        attachmentVO.setFileSize(Long.parseLong(fileInfo[3]));
        attachmentVO.setFilePath(new_fileDir.getPath());
        attachmentVO.setContentType(fileInfo[4]);
        attachmentVO.setImageHeight(Integer.parseInt(fileInfo[6]));
        attachmentVO.setImageWidth(Integer.parseInt(fileInfo[5]));



        return attachmentVO;
    }

    /**
     * 선택한 이미지들을 썸네일 파일을 생성
     * @param serviceId
     * @param arrFile
     * @return
     */
    public AttachmentVO uploadImageThumbnail(String serviceId, String arrFile) {
        String[] fileInfo = arrFile.split("\\|");
        String[] filePath = fileInfo[1].split(Constants.FILE_NAME_DECIMAL);

        File fileDir = new File(
                                this.uploadRootPath
                                + File.separator
                                + serviceId
                                + File.separator
                                + filePath[1]);
        if( !fileDir.exists() ){
            fileDir.mkdirs();
        }

        try {

            Path path = Paths.get(fileDir + Constants.FILE_NAME_DECIMAL + fileInfo[1]);
            byte[] data = Files.readAllBytes(path);

            FileOutputStream fos = new FileOutputStream(fileDir + Constants.FILE_NAME_DECIMAL + "thum_" + fileInfo[1], true);

            ThumbnailUtil.createThumbnail(data, fos, 50);

        } catch (Exception e) {
            e.printStackTrace();
        }

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setOriginalFilename(fileInfo[2]);
        attachmentVO.setFileName(fileInfo[1]);
        attachmentVO.setFileSize(Long.parseLong(fileInfo[3]));
        attachmentVO.setFilePath(fileDir.getPath());
        attachmentVO.setContentType(fileInfo[4]);
        attachmentVO.setImageHeight(Integer.parseInt(fileInfo[6]));
        attachmentVO.setImageWidth(Integer.parseInt(fileInfo[5]));

        return attachmentVO;
    }

    /**
     * 이미지 url를 가지고 thumbnail를 만들때 사용
     * @param serviceId
     * @param imageUrl
     * @param ext
     * @return
     * @throws Exception
     */
    public AttachmentVO uploadImageUrlThumb(String serviceId, String imageUrl, String ext) throws Exception {

        if(StringUtils.isEmpty(serviceId) ||  StringUtils.isEmpty(imageUrl) ){
            return null;
        }

        URL url = new URL(imageUrl);

        Image image = new ImageIcon(FileCopyUtils.copyToByteArray(url.openStream())).getImage();
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        File f = new File(url.getFile());

        long systemCurrTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd");
        String dateDir = formatter.format(systemCurrTime);

        String filePath = this.uploadRootPath + "/" + serviceId + "/" + dateDir;

        String fileName = "";
        if ("".equals(ext)) {
            fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString();
        } else {
            fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString() + "." + ext;
        }

        File fileDir = new File(filePath);
        if( !fileDir.exists() ){
            fileDir.mkdirs();
        }

        f.renameTo(new File(fileDir, fileName));

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setOriginalFilename(fileName);
        attachmentVO.setContentType("image");
        attachmentVO.setFileName(fileName);
        attachmentVO.setFilePath(filePath);
        attachmentVO.setFileSize(f.length());
        attachmentVO.setImageWidth(imageWidth);
        attachmentVO.setImageHeight(imageHeight);

        Path path = Paths.get(fileDir + Constants.FILE_NAME_DECIMAL + fileName);
        byte[] data = Files.readAllBytes(path);

        FileOutputStream fos = new FileOutputStream(fileDir + Constants.FILE_NAME_DECIMAL + "thum_" + fileName, true);

        ThumbnailUtil.createThumbnail(data, fos, 50);

        return attachmentVO;
    }

    public AttachmentVO getAttachment(String attachmentId) {
        //인자값검증 추가 : 2011-04-20
        if(StringUtils.isEmpty(attachmentId)){
            return null;
        }

        String[] attachmentIds = StringUtils.split(attachmentId, Constants.FILE_NAME_DECIMAL);
        if(attachmentIds.length != 3){
            return null;
        }

        String serviceId = attachmentIds[0];
        String dateDir = attachmentIds[1];
        String originalFilename = attachmentId;

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setFilePath(this.uploadRootPath + "/" + serviceId + "/" + dateDir);
        attachmentVO.setOriginalFilename(originalFilename);

        return attachmentVO;
    }

    public boolean removeFile(String serviceId, String fileName) throws IOException {

        AttachmentVO attachmentVO = getImage(fileName);
        File file = new File(attachmentVO.getFilePath()+File.separator+attachmentVO.getOriginalFilename());
        file.delete();
        return file.delete();
    }


}


