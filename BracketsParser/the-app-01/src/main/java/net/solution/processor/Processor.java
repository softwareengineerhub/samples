package net.solution.processor;

import java.util.List;

public interface Processor {

    //1) 2)
    public boolean createEquation(String text);

    public boolean solveEquation(String text, double xValue);

    public List<String> findAllEquationsByX(double xValue);

}
