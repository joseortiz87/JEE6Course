/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author JAVA
 */
@Path("/persona")
public class PersonasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonasResource
     */
    public PersonasResource() {
    }

    /**
     * Retrieves representation of an instance of com.practicas.web.PersonasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/profesor/{curp}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfesor(@PathParam("curp") String curp) {
        //TODO return proper representation object
        Profesor profesor = new Profesor();
        profesor.setCurp(curp);
        profesor.leerProfesor();
        return Response.ok(
                response("Profesor",curp,profesor.toJson()),
                MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/chat/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChat(@PathParam("id") String id) {
        Chat chat = new Chat();
        chat.setId(id);
        chat.leerChat();
         return Response.ok(
                response("Mensaje",id,chat.toJson()),
                MediaType.APPLICATION_JSON).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public PersonaResource getPersonaResource(@PathParam("id") String id) {
        return PersonaResource.getInstance(id);
    }
    
    
    private String response(String operacion,String parametro,JSONObject json){
        JSONObject obj = new JSONObject();
        try{
            obj.put("operacion", operacion);
            obj.put("parametro", parametro);
            obj.put("resultado", json);
            return obj.toString(4);
        } catch (JSONException ex) {
            Logger.getLogger(OperacionsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj.toString();
    }
}
