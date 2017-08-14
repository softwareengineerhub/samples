/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutorialspoint.ch02;

import static junit.framework.Assert.assertEquals;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author prokopiukd
 */
@RunWith(EasyMockRunner.class)
public class MathApplicationTest {
    
    //identify class which is going to use the mock object
    @TestSubject
    private MathApplication mathApplication = new MathApplication();
    
    @Mock
    private CalculatorService calculatorService;
    
    @Test
    public void testAdd(){
        //add the behavior of calc service
        EasyMock.expect(calculatorService.add(10.0, 20.0)).andReturn(30.0);
        
        //check on the number of calls that can be made on a particular method
        EasyMock.expectLastCall().times(1);        
       // EasyMock.expectLastCall().times(0, 1);
       // EasyMock.expectLastCall().atLeastOnce();
       // EasyMock.expectLastCall().anyTimes();
        
        //activate mock
        EasyMock.replay(calculatorService);
        
        double res=mathApplication.add(10.0, 20.0);
        assertEquals(res, 30.0);
        
        //tests whether mock was involved
        EasyMock.verify(calculatorService);
        
        
        
    }
}
