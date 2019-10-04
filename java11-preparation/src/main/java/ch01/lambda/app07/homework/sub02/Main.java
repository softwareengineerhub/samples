/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app07.homework.sub02;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    private static final String FILE_PATH = "C:\\";
    
    public static void main(String[] args) {
        File file = new File(FILE_PATH);

        File[] files = file.listFiles((item)->!item.isDirectory() && item.getName().endsWith(".txt"));
        System.out.println(files.length);
        System.out.println(Arrays.toString(files));

    }

    public static void main3(String[] args) {
        File file = new File(FILE_PATH);

        File[] files = file.listFiles((item)->item.isDirectory());
        System.out.println(files.length);
        System.out.println(Arrays.toString(files));

    }

    public static void main2(String[] args) {
        File file = new File(FILE_PATH);

        File[] files = file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        System.out.println(files.length);
        System.out.println(Arrays.toString(files));

    }

}
