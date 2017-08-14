/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutorialspoint.ch03;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.runner.RunWith;

/**
 *
 * @author prokopiukd
 */
@RunWith(EasyMockRunner.class)
public class EasyMockSupportExample extends EasyMockSupport {
    
    @TestSubject
    private PersonService personService = new PersonService();
    @Mock
    private PersonDao personDao;
    
    /*
    
    gives 3 methods:
    replayAll() – Registers all the created mocks in one batch.
    verifyAll() – Verifies all the mock operations in one batch.
    resetAll() – Resets all the mock operations in one batch.    
    */
    
    
}
