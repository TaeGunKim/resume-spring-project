package com.mycompany.myapp.common.component.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.component.processor.AttachmentProcessor;
import com.mycompany.myapp.common.component.vo.AttachmentVO;

@Controller
@RequestMapping("/media")
public class MediaController {

	 private static final Logger LOG = LoggerFactory.getLogger(MediaController.class);

	    @Resource
	    private AttachmentProcessor attachmentProcessor;

	    @RequestMapping(value="/{imageId}.image", method = RequestMethod.GET)
	    public void getImage(HttpServletRequest request, HttpServletResponse response, @PathVariable String imageId) throws IOException {

	        LOG.debug("invoked 'getImage' method...");
	        AttachmentVO attachmentVO = null;
	        if(StringUtils.isNotEmpty(imageId) || StringUtils.equals(imageId,"not")){
	         attachmentVO = attachmentProcessor.getImage(imageId);
	        }

	        URL url=null;
	        File file = null;

	        ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream();

	        if(attachmentVO != null){//no 이미지 처리
	            file = new File(attachmentVO.getFilePath(), attachmentVO.getOriginalFilename());
	        }

	        if(attachmentVO == null || !file.exists()){
	            url = this.getClass().getResource( "/media/noimage_thumb.jpg" );
	            LOG.debug(url.getPath());
	            file = new File(url.getPath());
	        }

	        if(file.exists()) {
	            BufferedImage image = ImageIO.read(file);
	            //20181019 kimtg 기존 png로 호출하던 이미지를 jpg로 변경하니 웹 로딩속도는 빨라졌으나, 일부png파일이 문제가 되서 png로 올린 파일들은
	            //그대로png로 호출되도록 수정함
	            if(image.getType()==6) {
					ImageIO.write(image, "png", imageOutputStream);
				}else {
					ImageIO.write(image, "jpg", imageOutputStream);
				}
	            //ImageIO.write(image, "jpg", imageOutputStream);
	        }

	        byte[] imgByte = imageOutputStream.toByteArray();

	        response.setHeader("Cache-Control", "no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", 0);
	        response.setContentType("image/jpg");

	        ServletOutputStream responseOutputStream = response.getOutputStream();
	        responseOutputStream.write(imgByte);
	        responseOutputStream.flush();
	        responseOutputStream.close();

	    }

	    @RequestMapping(value="/{mediaId}.media", method = RequestMethod.GET)
	    public void getMedia(HttpServletRequest request, HttpServletResponse response, @PathVariable String mediaId) throws IOException {

	        LOG.debug("invoked 'getMedia' method...");

	        AttachmentVO attachmentVO = attachmentProcessor.getAttachment(mediaId);

	        URL url=null;
	        File file = null;
	        OutputStream out = null;
	        FileInputStream fis = null;

	        if(attachmentVO != null){//no 이미지 처리
	            file = new File(attachmentVO.getFilePath(), attachmentVO.getOriginalFilename());
	        }

	        if(attachmentVO == null || !file.exists()){
	            url = this.getClass( ).getResource( "/media/noimage_thumb.jpg" );
	            file = new File(url.getPath());
	        }

	        response.setContentLength((int) file.length() );
	        response.setHeader("Content-Transfer-Encoding", "binary");

	        try {
	            out = response.getOutputStream();
	            try {
	                fis = new FileInputStream(file);
	                FileCopyUtils.copy(fis, out);

	            } finally {
	                if (fis != null){
	                    try {fis.close();} catch (IOException ex) {}
	                }
	            }
	            out.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    @RequestMapping(value="{serviceId}/download.do", method = RequestMethod.GET)
	    public void getFileDownload(HttpServletRequest request, HttpServletResponse response,
	            @PathVariable("serviceId") String serviceId,
	            @RequestParam("attachmentId") String attachmentId,
	            @RequestParam("filename") String filename
	            ) throws Exception {

	        LOG.debug("invoked 'getFileDownload' method...");

	        AttachmentVO attachmentVO = attachmentProcessor.getAttachment(attachmentId);

	        File file = null;
	        OutputStream out = null;
	        FileInputStream fis = null;

	        if(attachmentVO != null){
	            file = new File(attachmentVO.getFilePath(), attachmentVO.getOriginalFilename());
	        }

	        if(attachmentVO == null || !file.exists()){
	            response.sendError(404);
	            return;
	        }

	        String originalFilename = attachmentVO.getOriginalFilename();
	        if(StringUtils.isBlank(originalFilename)){
	            originalFilename=System.currentTimeMillis() +"";
	        }

	        /** 브라우져 세팅 ------------------------- **/
	        String strClient = request.getHeader("User-Agent");
	        response.setHeader("Cache-control", "private");
	        if(strClient.indexOf("MSIE 5.5") != -1 ){
	            response.setHeader("Content-Type", "doesn/matter");
	            this.setDBCSHeader("Content-Disposition",
	                    "filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\";", response);

	        }else if(strClient.indexOf("MSIE") != -1 ){
	            response.setHeader("Content-Type", "application/octet-stream");
	            this.setDBCSHeader("Content-Disposition",
	                    "attachment;filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\";", response);

	        }else {
	            response.setHeader("Content-Type", "application/octet-stream");
	            this.setDBCSHeader("Content-Disposition",
	                    "attachment;filename=\"" + filename + "\";", response);
	        }
	        /** 브라우져 세팅 ------------------------- **/

	        response.setContentLength((int) file.length() );

	        try {
	            out = response.getOutputStream();
	            try {
	                fis = new FileInputStream(file);
	                FileCopyUtils.copy(fis, out);

	            } finally {
	                if (fis != null){
	                    try {fis.close();} catch (IOException ex) {}
	                }
	            }
	            out.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    @RequestMapping(value="{serviceId}/ckeditorUpload.do", method = RequestMethod.POST)
	    public void ckeditorUpload(HttpServletRequest request,
	            HttpServletResponse response,
	            @PathVariable("serviceId") String serviceId,
	            @RequestParam MultipartFile upload,
	            @RequestParam String CKEditorFuncNum
	            ) throws IllegalStateException, IOException{

	        LOG.debug("invoked 'ckeditorUpload' method...");

	        response.setContentType("text/html; charset=UTF-8");
	        response.setHeader("Cache-Control", "no-cache");
	        PrintWriter out = response.getWriter();
	        if(
	                !(StringUtils.equals(serviceId, Constants.SERVICE_ID_ACCOUNT)
	                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_BBS)
	                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_ORDER)
	                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_PRODUCTS))
	        ){
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert(\"잘못된 서비스식별자(serviceId)\");");
	            out.println("</script>");
	        }else{

	            AttachmentVO attachmentVO = attachmentProcessor.upload(serviceId, upload);
	            out.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
	                     + CKEditorFuncNum
	                     + ",'"
	                     + "/media/"+attachmentVO.getFileName()+".image"
	                     + "','이미지를 업로드 하였습니다.'"
	                     + ")</script>");

	        }
	        out.flush();
	        out.close();

	    }

	    @RequestMapping(value="{serviceId}/ckeditorUploader.do", method = RequestMethod.POST)
	    public ModelAndView ckeditorUploader(HttpServletRequest request,
	            HttpServletResponse response,
	            @PathVariable("serviceId") String serviceId,
	            @RequestParam MultipartFile upload
	            ) throws IllegalStateException, IOException{

	        LOG.debug("invoked 'ckeditorUploader' method...");

	        ModelAndView mav = new ModelAndView("jsonView");
	        if(
	                !(StringUtils.equals(serviceId, Constants.SERVICE_ID_ACCOUNT)
	                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_BBS)
	                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_ORDER)
	                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_PRODUCTS))
	        ){

	        }else{

	            AttachmentVO attachmentVO = attachmentProcessor.upload(serviceId, upload);
	            mav.addObject("uploaded","1");
	            mav.addObject("fileName", attachmentVO.getOriginalFilename());
	            mav.addObject("url","/media/"+attachmentVO.getFileName()+".image");
	            System.out.println(attachmentVO.toString());

	        }

	        return mav;


	    }

	    /**
	     * 파일업로드 Admin에서 팝업
	     * @param request
	     * @param response
	     * @param serviceId
	     * @param multipartFile
	     * @throws IllegalStateException
	     * @throws IOException
	     */
	    @RequestMapping(value="{serviceId}/uploadFile.do", method = RequestMethod.POST)
	    public void addUploadFile(HttpServletRequest request,
	            HttpServletResponse response,
	            @PathVariable("serviceId") String serviceId,
	            @RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException{

	        LOG.debug("invoked 'addUploadFile' method...");

	        response.setContentType("text/html; charset=UTF-8");
	        response.setHeader("Cache-Control", "no-cache");
	        PrintWriter out = response.getWriter();


	        if(
	                !(StringUtils.startsWith(serviceId, Constants.SERVICE_ID_ACCOUNT)
	                        || StringUtils.startsWith(serviceId, Constants.SERVICE_ID_BBS)
	                        || StringUtils.startsWith(serviceId, Constants.SERVICE_ID_ORDER)
	                        || StringUtils.startsWith(serviceId, Constants.SERVICE_ID_PRODUCTS))
	        ){
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert(\"잘못된 서비스식별자(serviceId)\");");
	            out.println("</script>");
	        }
	        String closeScript="";
	        String serviceId2=serviceId;

	        if(StringUtils.startsWith(serviceId, Constants.SERVICE_ID_BBS)){
	            closeScript = StringUtils.removeStart(serviceId, Constants.SERVICE_ID_BBS);
	            serviceId2=StringUtils.removeEnd(serviceId2, closeScript);

	        }


	        AttachmentVO attachmentVO = attachmentProcessor.upload(serviceId2, multipartFile);
	        String fileName = attachmentVO.getFileName();

	        String imgSrc ="/media/" +  fileName + ".image";
//	        out.println("<script src='/common/js/jquery/jquery.js'   type='text/javascript' charset='UTF-8'></script>");
	        out.println("<script type=\"text/javascript\">");
	        out.println("window.opener.set"+closeScript+"(");
	        out.println("       {");
	        out.println("           'fileUploadType' : 'new',");
	        out.println("           'filePath' : '" + imgSrc + "',");
	        out.println("           'originalFilename' : '" + attachmentVO.getOriginalFilename() + "',");
	        out.println("           'fileSize' : '" + attachmentVO.getFileSize() + "',");
	        out.println("           'fileName' : '" + attachmentVO.getFileName() + "',");
	        out.println("           'contentType' : '" + attachmentVO.getContentType() + "',");
	        out.println("           'imageHeight' : '" + attachmentVO.getImageHeight() + "',");
	        out.println("           'imageWidth' : '" + attachmentVO.getImageWidth() + "'");
	        out.println("       }");
	        out.println(");");
	        out.println("window.self.close();");
	        out.println("</script>");

	        out.flush();
	        out.close();

	    }


	    @RequestMapping(value="{serviceId}/uploadReFile.json", method = RequestMethod.GET)
	    public ModelAndView removeUploadFile(HttpServletRequest request,
	            HttpServletResponse response,
	            @PathVariable("serviceId") String serviceId,
	            @RequestParam("imageId") String imageId) {

	        LOG.debug("invoked 'removeUploadFile' method...");

	        AttachmentVO attachmentVO = attachmentProcessor.getImage(imageId);

	        File f = new File(attachmentVO.getFilePath(),attachmentVO.getOriginalFilename());

	        f.delete();

	        ModelAndView mav = new ModelAndView("jsonView");
	        mav.addObject("msgCode","100");
	        return mav;

	    }

	    private void setDBCSHeader(String header, String value, HttpServletResponse response) {
	        byte by[];
	        try {
	            by = value.getBytes(response.getCharacterEncoding());
	        }
	        catch (Exception ex) {
	            by = value.getBytes();
	        }
	        char c[] = new char[by.length];
	        for (int i=0;i<by.length;i++){
	            c[i]=(char)(((char)by[i])&0xff);
	        }
	        response.setHeader(header,new String(c));
	    }

	}
