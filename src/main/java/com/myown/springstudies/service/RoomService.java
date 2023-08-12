package com.myown.springstudies.service;

import com.myown.springstudies.data.entity.RoomEntity;
import com.myown.springstudies.data.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<String> listAvailableRooms() {
        Iterable<RoomEntity> roomEntities = roomRepository.findAll();
        List<String> rooms = new ArrayList<>();
        roomEntities.forEach(roomEntity -> rooms.add(roomEntity.getRoomNumber() + " - " + roomEntity.getName()));
        return rooms;
    }
}
