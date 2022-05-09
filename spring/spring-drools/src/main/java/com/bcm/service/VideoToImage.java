package com.bcm.service;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VideoToImage {

    /**
     * 视频抽帧
     * @param filePath 批量处理，视频所在文件夹
     * @param targetPath 输出图片文件夹
     * @throws Exception
     */
    public static void videoToImage(String filePath,String targetPath ) throws Exception {
        File file = new File(filePath);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i=0; i<files.length; i++) {
                String fpath = files[i].getParent()+"\\"+files[i].getName();
                //System.out.println(fpath);
                String fileName = files[i].getName();
                randomGrabberFFmpegImage(fpath, targetPath, fileName.substring(0, fileName.length()-4));
            }
        }
    }

    public static void randomGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName)
            throws Exception {
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();
        int ffLength = ff.getLengthInFrames();
        System.out.println("ffLength"+ffLength);
        System.out.println("帧率: " + ff.getFrameRate());
        System.out.println("视频长度: " + ff.getLengthInTime());
        Frame f;
        int t = 3;		//抽帧间隔，可以自行调节
        for (int k=0; k<ffLength; k++){
            String format = String.format("%05d", k);
            f = ff.grabImage();
            if (k%t==0){
                doExecuteFrame(f, targerFilePath, targetFileName, format);
            }
        }
        ff.stop();
    }

    public static void doExecuteFrame(Frame f, String targerFilePath, String targetFileName, String index) {
        if (null == f || null == f.image) {
            return;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        String imageMat = "jpg";
        String FileName = targerFilePath + File.separator + targetFileName + "_" + index + "." + imageMat;
        BufferedImage bi = converter.getBufferedImage(f);
        File output = new File(FileName);
        try {
            ImageIO.write(bi, imageMat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
