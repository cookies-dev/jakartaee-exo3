package org.wildfly.examples;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GettingStartedEndpoint {

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok("Hello!").build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") int id) {
        return Response.ok("GET").build();
    }

    @POST
    public Response createProduct(String product) {
        if (product != null && !product.isEmpty()) {
            return Response.status(Response.Status.CREATED).entity("POST").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, String product) {
        if (product != null && !product.isEmpty()) {
            return Response.ok("PUT").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        return Response.ok("DELETE").build();
    }
}
