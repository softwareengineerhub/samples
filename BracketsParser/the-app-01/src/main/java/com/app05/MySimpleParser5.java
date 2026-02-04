package com.app05;

public class MySimpleParser5 {

    //"3+4*5"
    //['3','+','4','*','5']
    public double calculate(String text){
        if(text.contains("+")){
            //1
            int plusPosition = text.indexOf("+");

            //3
            String leftText = text.substring(0, plusPosition);

            //4*5
            String rightText = text.substring(plusPosition+1);

            double left = calculate(leftText);
            double right = calculate(rightText);
            double res = left+right;
            return res;
        }
        if(text.contains("-")){
            String ttt = text.replaceAll("\\*-","").replaceAll("\\/-","");
            if(text.replaceAll("\\*-","").replaceAll("\\/-","").contains("-")) {
                int minusPosition = text.indexOf("-");
                while(true) {
                    char leftChar = text.charAt(minusPosition-1);
                    boolean a = leftChar=='*';
                    boolean b = leftChar=='/';
                    if(a || b){
                        minusPosition = text.indexOf("-", minusPosition+1);
                    }else{
                        break;
                    }
                }

                String leftText = text.substring(0, minusPosition);

                String rightText = text.substring(minusPosition + 1);

                double left = calculate(leftText);
                double right = calculate(rightText);
                double res = left - right;
                return res;
            }
        }

        if(text.contains("*")){
            if(!text.contains("*-")) {
                //4*5

                //1
                int starPosition = text.indexOf("*");

                //4
                String leftText = text.substring(0, starPosition);

                //*5  --> 5
                String rightText = text.substring(starPosition + 1);

                //4
                double left = calculate(leftText);
                //5
                double right = calculate(rightText);
                double res = left * right;
                return res;
            } else {
                int starPosition = text.indexOf("*-");
                String leftText = text.substring(0, starPosition);
                String rightText = text.substring(starPosition + 2);
                double left = calculate(leftText);
                double right = -1*calculate(rightText);
                double res = left * right;
                return res;
            }
        }
        if(text.contains("/")){
            if(!text.contains("/-")) {
                int devidePosition = text.indexOf("/");
                String leftText = text.substring(0, devidePosition);
                String rightText = text.substring(devidePosition + 1);
                double left = calculate(leftText);
                double right = calculate(rightText);
                double res = left / right;
                return res;
            } else {
                int starPosition = text.indexOf("/-");
                String leftText = text.substring(0, starPosition);
                String rightText = text.substring(starPosition + 2);
                double left = calculate(leftText);
                double right = -1*calculate(rightText);
                double res = left / right;
                return res;
            }
        }

        if(text.isEmpty()){
            return 0;
        }
        return Double.parseDouble(text);
    }

}
