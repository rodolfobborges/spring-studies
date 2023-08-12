package com.myown.springstudies.service;


import com.myown.springstudies.model.GreetingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${greeting.message}")
    private String greeting;

    private final RoomService roomService;

    public GreetingService(RoomService roomService) {
        this.roomService = roomService;
    }

    public GreetingResponse getGreeting() {
        GreetingResponse greetingResponse = new GreetingResponse();
        greetingResponse.setGreetingMessage(greeting);
        greetingResponse.setAvailableRooms(roomService.listAvailableRooms());
        return greetingResponse;
    }
}
