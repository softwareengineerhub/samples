/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutorialspoint.ch03;

import static junit.framework.Assert.assertTrue;
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
public class PersonServiceTest {

    @TestSubject
    private PersonService personService = new PersonService();
    @Mock
    private PersonDao personDao;

    @Test
    public void test() {
        personService.setPersonDao(personDao);
        EasyMock.expect(personDao.makeAction(20.0, 10.0)).andReturn(30.0);
        EasyMock.replay(personDao);

        double res = personService.makeAction(20.0, 10.0);
        Assert.assertTrue(res == 30.0);
    }

    @Test(expected = NullPointerException.class)
    public void testException() {
        PersonDao personDaoMock = EasyMock.createMock(PersonDao.class);
        personService.setPersonDao(personDaoMock);
        EasyMock.expect(personDaoMock.makeAction(40.0, 50.0)).andThrow(new NullPointerException());
        EasyMock.replay(personDaoMock);
        double res = personService.makeAction(40.0, 50.0);
    }

    //niceMock - providesdefault impl, createMock - throws Exception when no rules are applied
    @Test
    public void testNiceMock() {
        PersonDao personDaoMock = EasyMock.createNiceMock(PersonDao.class);
        personService.setPersonDao(personDaoMock);
        EasyMock.replay(personDaoMock);
        double res = personService.makeAction(40.0, 50.0);
        assertTrue(res == 0.0);
    }
}
