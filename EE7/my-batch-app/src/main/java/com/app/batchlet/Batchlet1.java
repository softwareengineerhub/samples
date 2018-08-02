package com.app.batchlet;



import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

@Named(value = "Batchlet1")
public class Batchlet1 extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet : Batchlet1");
        // TODO code application logic here
        return "COMPLETED";
    }

}
