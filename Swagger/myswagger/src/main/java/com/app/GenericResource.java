/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author denys.prokopiuk
 */
@Path("generic")
@Api(value="generic")
public class GenericResource {

    @GET
    //@Path("/findByStatus")
    @ApiOperation(value = "Finds String ",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = String.class,
            responseContainer = "String")
    public String getXml() {
        return "hashCode=" + hashCode();
    }

}
