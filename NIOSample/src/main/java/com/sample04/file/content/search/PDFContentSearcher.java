/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample04.file.content.search;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.nio.file.Path;

/**
 *
 * @author prokopiukd
 */
public class PDFContentSearcher implements ContentSearcher {

    @Override
    public boolean searchInText(Path file, String keyWord) {
        PdfReader reader = null;
        try {
            reader = new PdfReader(file.toFile().getAbsolutePath());
            int n = reader.getNumberOfPages();
            for (int i = 1; i <= n; i++) {
                String text = PdfTextExtractor.getTextFromPage(reader, i);
                if (ContentSearcher.contains(text, keyWord)) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
