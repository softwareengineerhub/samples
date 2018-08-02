

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

@Named
public class Batchlet2 extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet : Batchlet2");
        return "COMPLETED";
    }

}
