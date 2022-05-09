package com.bcm.service;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextMove {

/*    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 900;*/

    private static final int FRAME_WIDTH = 720*2;
    private static final int FRAME_HEIGHT = 1280*2;
    /**
     * 字符动画
     * @param filePath
     * @throws IOException
     * @throws InterruptedException
     */
    public static void textMove(String filePath) throws IOException, InterruptedException {
        //JFrame的相关内容自行学习
        JFrame frame = new JFrame();
        frame.setTitle("shiyijiang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setResizable(true); //设置框架是否可由用户调整大小。
        frame.setUndecorated(false); //禁用或启用此框架的装饰
        JTextArea area = new JTextArea();
        area.setBackground(Color.white);
        area.setForeground(Color.BLACK);
        area.setSize(FRAME_WIDTH,FRAME_HEIGHT);
       // area.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT);
        area.setFont(new Font("微软雅黑",Font.PLAIN,10));
        frame.add(area);

        frame.setVisible(true);
        File file =new File(filePath);
        show(area,file);
    }

    /**
     * 显示到窗口
     * @param area
     * @param file
     * @throws IOException
     * @throws InterruptedException
     */
    public static void show(JTextArea area, File file) throws IOException, InterruptedException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        int line = 0;
        int page = 0;
        String[] pageStr=new String[139];
        while (line <= 4000 ) {  //总行数
            String str = br.readLine();
            sb.append(str+"\r\n");
            line++;
            if(line%100 == 0){  // 每帧的行数
                page++;
                //System.out.print(sb);
                pageStr[page] = sb.toString();
                sb = new StringBuffer();
                area.setText(pageStr[page]);
                Thread.sleep(100); //视觉暂留
            }
        }
        for(int j=0;j<1000;j++){
            for(String sss : pageStr){
                area.setText(sss);
                Thread.sleep(100);
            }
        }

    }
}