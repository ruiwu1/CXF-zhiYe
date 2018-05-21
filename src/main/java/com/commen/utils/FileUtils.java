package com.commen.utils;

import java.io.File;
import java.util.List;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
public class FileUtils {

    public static List<String> getFileList(File parentDir, List<String> list, String fileType) {
                File[] files = parentDir.listFiles();

                        for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(fileType)) {
                               System.out.println(file.getAbsoluteFile());
                                list.add(file.getAbsolutePath());
                           } else if (file.isDirectory()) {
                               getFileList(file, list, fileType);
                           }
                    }
                return list;
           }

    //判断文件夹是否存在，如果不存在，则创建

    // 判断文件夹是否存在
    public static void judeDirExists(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("dir exists");
            } else {
                System.out.println("the same name file exists, can not create dir");
            }
        } else {
            System.out.println("dir not exists, create it ...");
            file.mkdirs();
        }

    }
}
