/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample04.file.content.search;

import java.nio.file.Path;

/**
 *
 * @author prokopiukd
 */
public interface ContentSearcher {

    public boolean searchInText(Path file, String keyWord);

    public static boolean contains(String text, String keyWord) {
        if (text == null || keyWord == null) {
            return false;
        }
        return text.toLowerCase().contains(keyWord.toLowerCase());
    }

}
