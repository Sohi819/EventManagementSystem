package com.demo.eventmanagement.db.dao;

import com.demo.eventmanagement.db.connector.H2DatabaseClient;
import com.demo.eventmanagement.db.dto.Event;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDAO {

  public Event addUserToEvent(String eventId, String[] users) {
    EventDAO eventDAO = new EventDAO();
    List<Event> eventList = eventDAO.getEvent(eventId);

    if (eventList == null || eventList.size() == 0) {
      System.out.println("Event with eventId: " + eventId + " doesn't exists.");
      return null;
    }

    for (String user : users) {
      String username = addUser(eventId, user);
      System.out.println("Username: " + username + " added successfully in eventId: " + eventId);
    }
    return eventList.get(0);
  }

  private String addUser(String eventId, String username) {
    H2DatabaseClient databaseClient = new H2DatabaseClient();
    try {

      PreparedStatement ps = databaseClient.getPreparedStatement("INSERT INTO event_user (event_id, username) VALUES(?,?)");

      ps.setLong(1, Long.parseLong(eventId));
      ps.setString(2, username);

      int count = ps.executeUpdate();
      System.out.println("username inserted: " + count);

    } catch (Exception e) {
      System.out.print("Unable to insert userName in db: " + e.getMessage());
      e.printStackTrace();
      return null;
    }

    return username;
  }

}
