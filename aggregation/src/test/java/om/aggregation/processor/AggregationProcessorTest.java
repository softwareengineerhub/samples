/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package om.aggregation.processor;

import com.aggregation.model.Item;
import com.aggregation.processor.AggregationProcessor;
import com.aggregation.processor.AggregationProcessorImpl;
import com.aggregation.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class AggregationProcessorTest {

    @Test
    public void test() {
        AggregationProcessor aggregationProcessor = new AggregationProcessorImpl();
        Item actualResultItem = aggregationProcessor.process(Utils.initExpectedValues(10, "5/14/2019"));
        Item expectedResultItem = Utils.initPartitionAggregationItem();
        Assert.assertEquals(expectedResultItem, actualResultItem);
    }

}
