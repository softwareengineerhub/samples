/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample06.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyFileWriter {
    
    public static void main(String[] args) throws IOException {
        try(FileWriter fw = new FileWriter(new File(""), true)){
            
        }
    }
    
}
