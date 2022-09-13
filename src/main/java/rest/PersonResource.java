package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RenameMeDTO;
import facades.FacadeExample;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET // virkede med get, men det skal vel være POST
    @Path("/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response addPerson(@QueryParam("fname") String fName, @QueryParam("lname") String lName, @QueryParam("phone") String phone) {
       return Response.ok().entity(GSON.toJson(FACADE.addPerson(fName, lName, phone))).build();
    }

    // MANGLER REST FOR DELETING A PERSON
    // ...


    //http://localhost:8080/REST_Persons_DTO_war_exploded/api/person/1
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPerson(@PathParam("id") int id) {
        return Response.ok().entity(GSON.toJson(FACADE.getPerson(id))).build();
    }

    //http://localhost:8080/REST_Persons_DTO_war_exploded/api/person/all
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllPersons() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllPersons())).build();
    }


}
