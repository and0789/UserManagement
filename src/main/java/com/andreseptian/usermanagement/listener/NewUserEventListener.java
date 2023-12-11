package com.andreseptian.usermanagement.listener;

import com.andreseptian.usermanagement.event.NewUserEvent;
import com.andreseptian.usermanagement.service.EventService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.andreseptian.usermanagement.utils.RequestUtils.getDevice;
import static com.andreseptian.usermanagement.utils.RequestUtils.getIpAddress;

@Component
@RequiredArgsConstructor
public class NewUserEventListener {
    private final EventService eventService;
    private final HttpServletRequest request;

    @EventListener
    public void onNewUserEvent(NewUserEvent event) {
        eventService.addUserEvent(event.getEmail(), event.getType(), getDevice(request), getIpAddress(request));
    }
}

