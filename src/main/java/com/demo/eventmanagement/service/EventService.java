package com.demo.eventmanagement.service;

import com.demo.eventmanagement.api.request.EventRequest;
import com.demo.eventmanagement.db.dao.EventDAO;
import com.demo.eventmanagement.db.dao.UserDAO;
import com.demo.eventmanagement.db.dto.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {

  public List<Event> getEventsByDate() {
    EventDAO eventDAO = new EventDAO();
    List<Event> eventsList = null;
    eventsList = eventDAO.getAllEvents();
    System.out.println("eventsList >> ");
    System.out.println(eventsList);
    return eventsList;
  }

  public Map<String, List<Event>> getEventsByDate(EventRequest eventRequest) {
    EventDAO eventDAO = new EventDAO();
    List<Event> eventsList = null;
    eventsList = eventDAO.getAllEvents(eventRequest);
    System.out.println("eventsList >> ");
    System.out.println(eventsList);

    Map<String, List<Event>> eventsByDate = groupEventsByDate(eventsList);

    return eventsByDate;
  }

  private Map<String, List<Event>> groupEventsByDate(List<Event> eventsList) {
    Map<String, List<Event>> eventsByDate = new HashMap<>();
    for (Event event : eventsList) {
      String dateKey = event.getEventDate().substring(0, 10);
      System.out.println("dateKey : " + dateKey);
      if (eventsByDate.get(dateKey) == null) {
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        eventsByDate.put(dateKey, eventList);
      } else {
        eventsByDate.get(dateKey).add(event);
      }
    }
    return eventsByDate;
  }

  public boolean registerEvent(Event event) {
    EventDAO eventDAO = new EventDAO();
    Event resultEvent = eventDAO.addEvent(event);
    return resultEvent != null;
  }

  public Event registerUserForEvent(String eventId, String[] users) {
    UserDAO userDAO = new UserDAO();
    Event resultEvent = userDAO.addUserToEvent(eventId, users);
    return resultEvent;
  }

  //TODO implement these
  public int updateEvent(long eventId, Event event) {
    return 0;
  }

  //TODO implement these
  public int deleteEvent(long eventId) {
    return 0;
  }

}
