package net.solution.resolver;

import net.solution.calculator.Calculator;

public class EquationResolverImpl implements EquationResolver {
    private Calculator calculator;

    public EquationResolverImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public boolean isSolution(String equationText, double x) {
        int position = equationText.indexOf("=");
        String left = equationText.substring(0, position);
        String right = equationText.substring(position + 1);

        //Assert.assertTrue(resolver.isSolution("2*x+5=17", 6));
        //Assert.assertTrue(resolver.isSolution("17=2*x+5", 6));
        //Assert.assertTrue(resolver.isSolution("2*x+5=17", 6));
        /*
               left = "17"
               right = "2*x+5"
               ------------
               tmp = "17"
               left = "17"
               right = "2*x+5"
               -----------------
               tmp = "17"
               left = "2*x+5"
               right = "2*x+5"
               -----------------
               tmp = "17"
               left = "2*x+5"
               right = "17"

         */

        //simetric under ==
        if (right.contains("x")) {
            String tmp = left;
            left = right;
            right = tmp;
        }

        //=17
        double expectedResult = Double.parseDouble(right);
        //String parameter = left.replace("x", x + "");
        //2*x+5=
        double calcResult = calculator.calculate(left, x);
        return calcResult == expectedResult;
    }
}
