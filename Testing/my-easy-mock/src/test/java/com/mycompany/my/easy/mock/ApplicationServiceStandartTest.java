/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.easy.mock;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prokopiukd
 */
public class ApplicationServiceStandartTest {

    private ApplicationService applicationService;
    private Collaborator mock;

    @Before
    public void setUp() {
        mock = EasyMock.createMock(Collaborator.class);
        applicationService = new ApplicationService();
        applicationService.setListener(mock);
    }

    @Test
    public void testRemoveNonExistingDocument() {
        applicationService.addDocument("Doe not exist", "");
    }
}
