package com.andreseptian.usermanagement.repository;

import com.andreseptian.usermanagement.domain.UserEvent;
import com.andreseptian.usermanagement.enumeration.EventType;

import java.util.Collection;

public interface EventRepository {
    Collection<UserEvent> getEventsByUserId(Long userId);
    void addUserEvent(String email, EventType eventType, String device, String ipAddress);
    void addUserEvent(Long userId, EventType eventType, String device, String ipAddress);
}
