/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
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
@Path("/operacion")
public class OperacionsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperacionsResource
     */
    public OperacionsResource() {
    }

    /**
     * Retrieves representation of an instance of com.practicas.web.OperacionsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandom() {
        //TODO return proper representation object
        Random random = new Random();
        return Response.ok(
                response("Numero Aleatorio","",String.valueOf(random.nextDouble()*1000)),
                MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postRandom(){
        return Response.ok(
                response("Numero Aleatorio POST","","No puedo guardar"),
                MediaType.APPLICATION_JSON).build();
    }

    /**
     * POST method for creating an instance of OperacionResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public OperacionResource getOperacionResource(@PathParam("id") String id) {
        return OperacionResource.getInstance(id);
    }
    
    private String response(String operacion,String parametro,String resultado){
        JSONObject obj = new JSONObject();
        try{
            obj.put("operacion", operacion);
            obj.put("parametro", parametro);
            obj.put("resultado", resultado);
            return obj.toString(4);
        } catch (JSONException ex) {
            Logger.getLogger(OperacionsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj.toString();
    }
}
