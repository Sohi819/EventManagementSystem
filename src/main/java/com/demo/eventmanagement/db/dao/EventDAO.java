package com.demo.eventmanagement.db.dao;

import com.demo.eventmanagement.db.connector.DatabaseClient;
import com.demo.eventmanagement.db.dto.Event;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

  public List<Event> getAllEvents() throws SQLException {
    DatabaseClient databaseClient = new DatabaseClient();
    String query = "Select * from EVENT";
    ResultSet resultSet = databaseClient.executeSelect(query);

    List<Event> eventList = new ArrayList<>();
    while (resultSet.next()) {
      long eventId = resultSet.getLong("event_id");
      String eventName = resultSet.getString("event_name");
      String speaker = resultSet.getString("speaker");
      String startDate = resultSet.getString("start_date");
      String endDate = resultSet.getString("end_date");
      String venue = resultSet.getString("venue");

      Event obj = new Event(eventId, eventName, speaker, startDate, endDate, venue);
      eventList.add(obj);
    }
    System.out.println("eventList: ");
    System.out.println(eventList);
    return eventList;
  }

  public Event addEvent(Event event) {
    DatabaseClient databaseClient = new DatabaseClient();
    try {

      PreparedStatement ps = databaseClient.getPreparedStatement("INSERT INTO event (event_name, speaker, start_date, end_date, venue) VALUES(?,?,?,?,?)");

      ps.setString(1, event.getEventName());
      ps.setString(2, event.getSpeaker());
      ps.setString(3, event.getStartDate());
      ps.setString(4, event.getEndDate());
      ps.setString(5, event.getVenue());

      int count = ps.executeUpdate();
      System.out.println("Event inserted: " + count);

    } catch (Exception e) {
      System.out.print("Unable to insert Event in db: " + e.getMessage());
      e.printStackTrace();
      return null;
    }

    return event;
  }

}
