package com.demo.eventmanagement.api;

import com.demo.eventmanagement.db.dao.EventDAO;
import com.demo.eventmanagement.db.dto.Event;
import com.demo.eventmanagement.service.EventService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/events")
public class EventResource {

  @GET
  @Produces("application/json")
  public List<Event> getEvent() {
    EventService eventService = new EventService();
    List<Event> events = eventService.getEvents();
    System.out.println(events);
    return events;
  }


  @POST
  @Path("/register")
  @Produces("application/json")
  @Consumes("application/json")
  public Response addEvent(Event event) {
    EventService eventService = new EventService();
    boolean result = eventService.registerEvent(event);

    System.out.println(result);
    
    if (result) {
      return Response.ok(event).build();
    } else {
      return Response.serverError().build();
    }
  }

  @PUT
  @Path("/update/{id}")
  @Consumes("application/json")
  public Response updateEvent(@PathParam("id") int id, Event emp) {
    EventDAO dao = new EventDAO();
//    int count = dao.updateEvent(id, emp);
//    if (count == 0) {
//      return Response.status(Response.Status.BAD_REQUEST).build();
//    }
    return Response.ok().build();
  }

  @DELETE
  @Path("/delete/{id}")
  @Consumes("application/json")
  public Response deleteEvent(@PathParam("id") int id) {
    EventDAO dao = new EventDAO();
//    int count = dao.deleteEvent(id);
//    if (count == 0) {
//      return Response.status(Response.Status.BAD_REQUEST).build();
//    }
    return Response.ok().build();
  }
}
