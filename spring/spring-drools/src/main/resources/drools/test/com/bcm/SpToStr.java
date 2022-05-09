package com.bcm;

import com.bcm.service.ImageToStr;
import com.bcm.service.TextMove;
import com.bcm.service.VideoToImage;

public class SpToStr {
    public static void main(String[] args) throws Exception {
        //对视频进行抽帧得到图片
        VideoToImage.videoToImage("D:\\mov\\sp","D:\\mov\\img");
        //对图片进行处理得到字符画
        ImageToStr.createAsciiPic("D:\\mov\\img","D:\\mov\\txt\\shiyijiang.txt");
        //按照一定顺序和一定时间在终端打印字符画实现动画效果代码实现
        TextMove.textMove("D:\\mov\\txt\\shiyijiang.txt");
    }
}
