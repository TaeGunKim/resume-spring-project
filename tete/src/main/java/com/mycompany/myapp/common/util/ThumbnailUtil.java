package com.mycompany.myapp.common.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import com.twelvemonkeys.imageio.plugins.jpeg.JPEGImageWriter;

public class ThumbnailUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ThumbnailUtil.class);

	private BufferedImage source;
	private boolean enlargement;
	private int width;
	private int height;
	private int r=255;
	private int g=255;
	private int b=255;

//	public static void createThumbnail(String image, String thumb, int maxDim)
//			throws Exception {
//		OutputStream out = null;
//		InputStream in = null;
//		try {
//			out = new FileOutputStream(new File(thumb));
//			in = new FileInputStream(new File(image));
//			//createThumbnail(FileCopyUtils.copyToByteArray(in), out, maxDim);
//		} finally {
//			if (in != null)
//				in.close();
//			if (out != null)
//				out.close();
//		}
//	}

//	public static void createThumbnail(File image, File thumb, int maxDim)
//			throws Exception {
//		OutputStream out = null;
//		InputStream in = null;
//		try {
//			out = new FileOutputStream(thumb);
//			in = new FileInputStream(image);
//			createThumbnail(FileCopyUtils.copyToByteArray(in), out, maxDim);
//		} finally {
//			if (in != null)
//				in.close();
//			if (out != null)
//				out.close();
//		}
//	}

    public static void createThumbnail(byte[] in, FileOutputStream out, int maxDim)
            throws Exception {

        Image inImage = new ImageIcon(in).getImage();

        LOG.debug("width {}, height {}", inImage.getWidth(null), inImage.getHeight(null));

        double scale = (double) maxDim / (double) inImage.getHeight(null);
        if (inImage.getWidth(null) > inImage.getHeight(null)) {
            scale = (double) maxDim / (double) inImage.getWidth(null);
        }

        int scaledW = (int) (scale * inImage.getWidth(null));
        int scaledH = (int) (scale * inImage.getHeight(null));

        LOG.debug("width {}, height {}", scaledW, scaledH);

        BufferedImage outImage = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB);

        AffineTransform tx = new AffineTransform();

        // If the image is smaller than the desired image size, don't bother
        // scaling.
        if (scale < 1.0d) {
            tx.scale(scale, scale);
        }

        Graphics2D g2d = outImage.createGraphics();
        //g2d.drawImage(inImage, tx, null);
        g2d.drawImage(inImage, 0, 0, scaledW, scaledH, null);
        g2d.dispose();

        //JPEGImageEncoder encoderOut = JPEGCodec.createJPEGEncoder(out);
        //encoderOut.encode(outImage);

        saveAsJPEG("96", outImage, 1f, out);
    }

    public static void saveAsJPEG(String jpgFlag, BufferedImage image_to_save, float JPEGcompression, FileOutputStream fos) throws IOException {

        // Image writer
        JPEGImageWriter imageWriter = (JPEGImageWriter) ImageIO.getImageWritersBySuffix("jpeg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
        imageWriter.setOutput(ios);

        //and metadata
        IIOMetadata imageMetaData = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(image_to_save), null);

        if (jpgFlag != null){

            int dpi = 96;

            try {
                dpi = Integer.parseInt(jpgFlag);
            } catch (Exception e) {
                e.printStackTrace();
            }
     LOG.debug("dpi====={}", dpi);
            //new metadata
            Element tree = (Element) imageMetaData.getAsTree("javax_imageio_jpeg_image_1.0");
            Element jfif = (Element)tree.getElementsByTagName("app0JFIF").item(0);
            jfif.setAttribute("Xdensity", Integer.toString(dpi));
            jfif.setAttribute("Ydensity", Integer.toString(dpi));

        }

        if(JPEGcompression>=0 && JPEGcompression<=1f){

            //old compression
            //jpegEncodeParam.setQuality(JPEGcompression,false);

            // new Compression
            JPEGImageWriteParam jpegParams = (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();
            jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(JPEGcompression);

        }

        //old write and clean
        //jpegEncoder.encode(image_to_save, jpegEncodeParam);

        //new Write and clean up
        imageWriter.write(imageMetaData, new IIOImage(image_to_save, null, null), null);
        ios.close();
        imageWriter.dispose();

    }

	public static void createThumbnail2(File loadFile,  File saveFile, int maxDim)
			throws IOException {

		FileInputStream fis = new FileInputStream(loadFile);


		BufferedImage im = ImageIO.read(fis);
		Image inImage = new ImageIcon(loadFile.getAbsolutePath()).getImage();

		LOG.debug("width {}, height {}", inImage.getWidth(null), inImage.getHeight(null));

		double scale = (double) maxDim / (double) inImage.getHeight(null);
		if (inImage.getWidth(null) > inImage.getHeight(null)) {
			scale = (double) maxDim / (double) inImage.getWidth(null);
		}
		int scaledW = (int) (scale * inImage.getWidth(null));
		int scaledH = (int) (scale * inImage.getHeight(null));

		LOG.debug("scaledW {}, scaledH {}", scaledW, scaledH);

		BufferedImage thumb = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = thumb.createGraphics();
		g2.drawImage(im, 0, 0, scaledW, scaledH, null);
		ImageIO.write(thumb, "jpg", saveFile);
	}


	public void setSourceImage(BufferedImage source)
	{
		this.source = source;
	}

	public void setEnlargement(boolean enlargement)
	{
		this.enlargement = enlargement;
	}

	public void setSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public void setBackgroundColor(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public BufferedImage getScaledImage()
	{
		BufferedImage image = null;

		int scaleH = (this.height * 100) / this.source.getHeight();
		int scaleW = (this.width * 100) / this.source.getWidth();

		int scale = (scaleH > scaleW) ? scaleW : scaleH;

		if ((!(this.enlargement)) && (scale > 100))
		{
			scale = 100;
		}

		image = new BufferedImage((int)(this.source.getWidth() * scale / 100), (int)(this.source.getHeight() * scale / 100), BufferedImage.TYPE_INT_RGB);

		BufferedImage scaledImage = new BufferedImage((int)(this.source.getWidth() * scale / 100),
				(int)(this.source.getHeight() * scale / 100), 2);
		Graphics2D scaledG2d = scaledImage.createGraphics();

		AffineTransform at = new AffineTransform();
		at.scale(scale, scale);
		scaledG2d.drawImage(this.source, at, null);

		scaledG2d.dispose();

		Graphics2D g2d = image.createGraphics();

		g2d.setPaint(new Color(this.r, this.g, this.b));
		g2d.fill(new Rectangle(this.width, this.height));

		int x = (int)(image.getWidth() / 2.0D - (scaledImage.getWidth() / 2.0D));
		int y = (int)(image.getHeight() / 2.0D - (scaledImage.getHeight() / 2.0D));
		g2d.drawImage(scaledImage, null, x, y);

		g2d.dispose();
		image.flush();
		scaledImage.flush();

		return image;
	}
}
