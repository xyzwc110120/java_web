package com.cyx.java_web.web_04_file;

import org.apache.commons.io.FilenameUtils;

public class FilenameUtilsTest {
    public static void main(String[] args) {
        String path = "F:/mini_refresh.png";

        // 获取文件名称
        System.out.println(FilenameUtils.getName(path));        // mini_refresh.png
        // 获取文件名称，但是不包括拓展名
        System.out.println(FilenameUtils.getBaseName(path));    // mini_refresh
        // 获取拓展名
        System.out.println(FilenameUtils.getExtension(path));   // png
    }
}
