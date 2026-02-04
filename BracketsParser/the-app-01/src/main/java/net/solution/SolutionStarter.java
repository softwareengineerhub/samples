package net.solution;

import net.solution.processor.EquationProcessor;
import net.solution.processor.Processor;

import java.util.List;

public class SolutionStarter {

    public static void main(String[] args) {
        Processor processor = new EquationProcessor();

        boolean success = processor.createEquation("2*x+5=17");
        System.out.println("success="+success);

        //boolean isCorrect = processor.solveEquation("x+5=0", -5);
        //System.out.println("isCorrect="+isCorrect);

        //boolean isCorrect = processor.solveEquation("x-44=0", 44);
        //System.out.println("isCorrect="+isCorrect);

        //boolean isCorrect = processor.solveEquation("x-44*1=0", 44);
        //System.out.println("isCorrect="+isCorrect);

        //boolean isCorrect = processor.solveEquation("1-1+x-44=0", 44);
        //System.out.println("isCorrect="+isCorrect);

        List<String> resultList =  processor.findAllEquationsByX(-5);
        System.out.println(resultList);



    }

}
