/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample06.code;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPaths {
    
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\Denis\\Soft\\DevTools\\netbeans\\bin\\");
        Path p2 = Paths.get("netbeans\\bin\\netbeans64.exe");
        Path res = p1.resolve(p2);
        System.out.println(res);
    }
    
}
