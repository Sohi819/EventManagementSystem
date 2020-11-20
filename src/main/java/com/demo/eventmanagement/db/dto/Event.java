package com.demo.eventmanagement.db.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {

  private long eventId;
  private String eventName;
  private String speaker;
  private String startDate;
  private String endDate;
  private String venue;

  public Event() {
  }

  public Event(long eventId, String eventName, String speaker, String startDate, String endDate, String venue) {
    this.eventId = eventId;
    this.eventName = eventName;
    this.speaker = speaker;
    this.startDate = startDate;
    this.endDate = endDate;
    this.venue = venue;
  }

  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public String getSpeaker() {
    return speaker;
  }

  public void setSpeaker(String speaker) {
    this.speaker = speaker;
  }

  @Override
  public String toString() {
    return "Event{" +
        "eventId=" + eventId +
        ", eventName='" + eventName + '\'' +
        ", speaker='" + speaker + '\'' +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", venue='" + venue + '\'' +
        '}';
  }
}
