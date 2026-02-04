package net.solution.calculator;

//import SimpleParser.ParserBase;

public class MyRecursiveParser {


    public double evaluate(String text) {
        int delimiterPosition = findDelimiterPosition(text, '+');
        if(delimiterPosition>=0){
            String leftText = text.substring(0, delimiterPosition);
            String rightText = text.substring(delimiterPosition+1);
            double left = evaluate(leftText);
            double right = evaluate(rightText);
            return left+right;
        }

        delimiterPosition = findDelimiterPosition(text, '-');
        if(delimiterPosition>=0){
            String leftText = text.substring(0, delimiterPosition);
            String rightText = text.substring(delimiterPosition+1);
            double left = evaluate(leftText);
            double right = evaluate(rightText);
            return left-right;
        }

        delimiterPosition = findDelimiterPosition(text, '*');
        if(delimiterPosition>=0){
            String leftText = text.substring(0, delimiterPosition);
            String rightText = text.substring(delimiterPosition+1);
            double left = evaluate(leftText);
            double right = evaluate(rightText);
            return left*right;
        }

        delimiterPosition = findDelimiterPosition(text, '/');
        if(delimiterPosition>=0){
            String leftText = text.substring(0, delimiterPosition);
            String rightText = text.substring(delimiterPosition+1);
            double left = evaluate(leftText);
            double right = evaluate(rightText);
            return left*right;
        }

        if (text.charAt(0) == '(') {
            if (text.endsWith(")")) {
                text = text.substring(1, text.length() - 1);
                return evaluate(text);
            }
            throw new RuntimeException("Invalid brackets: "+text);
        }

        if(text.trim().isEmpty()){
            return 0;
        }

        return Double.parseDouble(text);
    }

    private int findDelimiterPosition(String s, char c)
    {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (s.charAt(i) == c && count == 0) return i;
        }
        return -1;
    }

    /*public int findDelimiterPosition(String text, char c){
        int opened = 0;
        int closed = 0;
        for(int i=0;i<text.length();i++){
            int positionFormTheEnd = text.length()-1-i;
            if(text.charAt(positionFormTheEnd)==c){
                opened++;
            } else if(text.charAt(positionFormTheEnd)==c){
                closed++;
            }
            if(opened==closed && opened!=0){
                return positionFormTheEnd;
            }
        }
        return -1;
    }*/

    public double evaluateHelper(String text) {
        int delimiterPosition = findDelimiterPosition(text, '+');
        String textA = text.substring(0, delimiterPosition);
        String textB = text.substring(delimiterPosition, text.length());
        System.out.println("textA="+textA);
        System.out.println("textB="+textB);

        return 0;
    }

}
