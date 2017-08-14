/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.easy.mock;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

/**
 *
 * @author prokopiukd
 */
public class ApplicationServiceTest extends EasyMockSupport {

    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator collaborator;

    @TestSubject
    private ApplicationService applicationService;// = new ApplicationService();

    @Test
    public void addDocument() {
        collaborator.documentAdded("New Document");
        replayAll();
        applicationService.addDocument("New Document", "content");
    }
}
