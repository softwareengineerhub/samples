/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.block.parser;

import java.util.Stack;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("A");
        stack.peek();
        
        String[] openTokens = {"{","("};
        String[] closeTokens = {"}",")"};
        System.out.println(validate("", openTokens, closeTokens));
        System.out.println(validate("{{()}", openTokens, closeTokens));
        System.out.println(validate("{}()(({}))", openTokens, closeTokens));
        System.out.println(validate("{{()}", openTokens, closeTokens));
        System.out.println(validate("{()", openTokens, closeTokens));
    }

    private static boolean validate(String str, String[] openTokens, String[] closeTokens) {
        Stack<String> stack = new Stack();
        for (char ch : str.toCharArray()) {
            for (String openToken : openTokens) {
                if (openToken.equals(ch+"")) {
                    stack.push(openToken);
                    break;
                }
            }

            for (int i = 0; i < closeTokens.length; i++) {
                String closeToken = closeTokens[i];
                String openToken = openTokens[i];
                if (closeToken.equals(ch+"")) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek().equals(openToken)) {
                        stack.pop();
                        break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
