package net.solution;

import net.solution.calculator.Calculator;
import net.solution.calculator.SimpleCalculator;
import net.solution.resolver.EquationResolver;
import net.solution.resolver.EquationResolverImpl;
import net.solution.validator.*;

import java.util.ArrayList;
import java.util.List;

public class AppStarter {

    public static void main(String[] args) {
        List<Validator> validatorList = new ArrayList<>();
        Validator defaultValidator = new DefaultValidator();
        Validator hasUniqueEqualValidator = new HasUniqueEqualValidator();
        Validator notEmptyExpressionsBothPartOfEqualValidator = new NotEmptyExpressionsBothPartOfEqualValidator();
        Validator variablesPresentOnlyOnOneSideOfEqualValidator = new VariablesPresentOnlyOnOneSideOfEqualValidator();
        Validator arithmeticOperationsValidator = new ArithmeticOperationsValidator();

        validatorList.add(defaultValidator);
        validatorList.add(notEmptyExpressionsBothPartOfEqualValidator);
        validatorList.add(variablesPresentOnlyOnOneSideOfEqualValidator);
        validatorList.add(arithmeticOperationsValidator);
        validatorList.add(hasUniqueEqualValidator);


        Calculator calculator = new SimpleCalculator();
        EquationResolver equationResolver = new EquationResolverImpl(calculator);

        boolean equationIsCorrect = true;

        //String text = "10=2*x";
        //String text = "2*x=10";
        //String text = "2*x+10";
        //String text = "1+x=x+10";
        String text = "";
        for(Validator validator : validatorList){
            if(!validator.isValid(text)){
                System.out.println("validator="+validator);
                equationIsCorrect = false;
                break;
            }
        }

        if(equationIsCorrect){
            boolean isSolution = equationResolver.isSolution(text, 5);
            System.out.println("isSolution="+isSolution);
        } else {
            System.out.println("Equation is not valid! Please check");
        }

    }

}
