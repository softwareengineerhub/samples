/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noxml;

import com.common.Person;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author prokopiukd
 */
public interface PersonMapper {

    @Select("SELECT * FROM person WHERE id = #{id}")
    Person selectPerson(int id);
}
