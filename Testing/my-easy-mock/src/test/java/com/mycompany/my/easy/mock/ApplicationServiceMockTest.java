/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.easy.mock;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author prokopiukd
 */
@RunWith(EasyMockRunner.class)
public class ApplicationServiceMockTest extends EasyMockSupport {

    @TestSubject
    private ApplicationService applicationService = new ApplicationService();
    @Mock
    private Collaborator mock;
    
    @Test
    public void testRemoveNonExistingDocument(){
        assertEquals(mock, applicationService.getListener());
        applicationService.addDocument("title", "document");
        replay(mock);
    }
    
}
