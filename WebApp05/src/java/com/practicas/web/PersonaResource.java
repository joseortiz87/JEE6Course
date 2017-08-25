/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author JAVA
 */
public class PersonaResource {

    private String id;

    /**
     * Creates a new instance of PersonaResource
     */
    private PersonaResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the PersonaResource
     */
    public static PersonaResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of PersonaResource class.
        return new PersonaResource(id);
    }

    /**
     * Retrieves representation of an instance of com.practicas.web.PersonaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource PersonaResource
     */
    @DELETE
    public void delete() {
    }
}
