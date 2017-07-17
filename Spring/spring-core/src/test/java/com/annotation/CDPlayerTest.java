/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.common.interfaces.CompactDisk;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author denys
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = "/com/annotation/annotation-config.xml")
@ContextConfiguration(locations = { "classpath:/com/annotation/annotation-config-test.xml" })
public class CDPlayerTest {

    @Autowired
    private CompactDisk cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

}
