/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample04.file.content.search;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException {
        ContentSearcher contentSearcher = new PDFContentSearcher();
        Path path = Paths.get(Main.class.getResource("/data/pdf-sample.pdf").toURI());
        boolean res = contentSearcher.searchInText(path, "Web");
        System.out.println("res=" + res);
    }

}
