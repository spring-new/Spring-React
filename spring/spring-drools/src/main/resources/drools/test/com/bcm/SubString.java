package com.bcm;

public class SubString {
    public static void main(String args[]) {
        // String filePath = "C:\\Users\\Wcs\\Desktop\\中台\\需求\\NZdown_load.xls";
        String filePath = "/\\//22/772100/098097_7120220214000087.xls";
        //String filePath = "C:\\\\Users\\\\Wcs\\\\Desktop\\\\中台\\\\需求\\\\NZdown_load\\772100098097_7120220214000087.xls";


        if (filePath.contains("xls")) {
            String tGrpContNo = filePath.substring(filePath.lastIndexOf("/") + 1).split("_")[0];
            System.out.println("tGrpContNo:   " + tGrpContNo);
        }
        // NZ_6120191024000018_01.xls
        if (filePath.contains("xls")) {
            String tEdortype = filePath.substring(filePath.lastIndexOf("/") + 1).split("_")[0];
            String tBatchNo = filePath.substring(filePath.lastIndexOf("/") + 1).split("\\.")[0];
            String tFileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            System.out.println("tEdortype:   " + tEdortype);
            System.out.println("tBatchNo :   " + tBatchNo);
            System.out.println("tFileName:   " + tFileName);


        }

    }
}
