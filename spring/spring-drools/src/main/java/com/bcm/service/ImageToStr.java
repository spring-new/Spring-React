package com.bcm.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageToStr {
    /**
     * 图片转字符
     * @param filePath
     * @param targetPath
     */
    public static void createAsciiPic(String filePath,String targetPath) {
          //final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        final String base = "KSPksp;,";
        try {	//输出图片文件夹
            File file = new File(filePath);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(targetPath);//创建文本文件
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter bw = new BufferedWriter(fileWriter);
            if (file.isDirectory()){
                File[] files = file.listFiles();
                System.out.println(files.length);
                for (int i=0; i<files.length; i++) {
                    //System.out.println(files[i].getName());
                    BufferedImage image = ImageIO.read(files[i]);
                    for (int y = 0; y < image.getHeight(); y += 4) {
                        StringBuilder sss=new StringBuilder ( "" );
                        for (int x = 0; x < image.getWidth(); x+=2) {
                            final int pixel = image.getRGB(x, y);
                            final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                            final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                            final int index = Math.round(gray * (base.length() + 1) / 255);
                            sss.append(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                        }
                        String s = sss.toString()+"\r\n";
                        bw.write(s);// 往已有的文件上添加字符串
                    }
                }
            }
            bw.close();
            fileWriter.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}