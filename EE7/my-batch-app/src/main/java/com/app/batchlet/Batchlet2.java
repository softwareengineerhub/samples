package com.app.batchlet;



import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

@Named(value = "Batchlet2")
public class Batchlet2 extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet : Batchlet2");
        return "COMPLETED";
    }

}
