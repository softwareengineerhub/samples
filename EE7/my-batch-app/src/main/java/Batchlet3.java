/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

/**
 *
 * @author denys.prokopiuk
 */
@Named
public class Batchlet3 extends AbstractBatchlet {
    
    @Override
    public String process() {
        System.out.println("Running inside a batchlet : Batchlet3");
        // TODO code application logic here
        return "COMPLETED";
    }
    
}
