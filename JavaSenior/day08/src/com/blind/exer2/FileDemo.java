package com.blind.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author blind
 * @create 2022-09-21-15:02
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("d:\\IO\\hello.txt");
        //创建一个与file同目录下的另一个文件，文件名为haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
    }
}
