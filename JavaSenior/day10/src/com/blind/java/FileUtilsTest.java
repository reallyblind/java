package com.blind.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author blind
 * @create 2022-09-29-16:20
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File scrFile = new File("day10\\水.jpg");
        File destFile = new File("day10\\水3.jpg");

        try {
            FileUtils.copyFile(scrFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
