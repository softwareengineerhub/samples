package com.app02;

public class SimpleValidator {

    //2*x+5=17,
    public boolean isValid(String text){
        //+
        if(text.contains("++")){
            return false;
        }
        if(text.contains("+-")){
            return false;
        }
        if(text.contains("+*")){
            return false;
        }
        if(text.contains("+/")){
            return false;
        }

        //-
        if(text.contains("-+")){
            return false;
        }
        if(text.contains("--")){
            return false;
        }
        if(text.contains("-*")){
            return false;
        }
        if(text.contains("-/")){
            return false;
        }

        //*
        if(text.contains("*+")){
            return false;
        }
        if(text.contains("*-")){
            return false;
        }
        if(text.contains("**")){
            return false;
        }
        if(text.contains("*/")){
            return false;
        }

        // /
        if(text.contains("/+")){
            return false;
        }
        if(text.contains("/-")){
            return false;
        }
        if(text.contains("/*")){
            return false;
        }
        if(text.contains("//")){
            return false;
        }
        return true;
    }

}

