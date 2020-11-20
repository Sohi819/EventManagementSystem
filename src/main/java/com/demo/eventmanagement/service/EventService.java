package com.demo.eventmanagement.service;

import com.demo.eventmanagement.db.dao.EventDAO;
import com.demo.eventmanagement.db.dto.Event;
import java.sql.SQLException;
import java.util.List;

public class EventService {

  public List<Event> getEvents() {
    EventDAO eventDAO = new EventDAO();
    List<Event> eventsList = null;
    try {
      eventsList = eventDAO.getAllEvents();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("eventsList >> ");
    System.out.println(eventsList);
    return eventsList;
  }

  public boolean registerEvent(Event event) {
    EventDAO eventDAO = new EventDAO();
    Event resultEvent = eventDAO.addEvent(event);
    return resultEvent != null;
  }
}
