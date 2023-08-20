package com.myown.springstudies.webservice;

import com.myown.springstudies.data.entity.RoomEntity;
import com.myown.springstudies.data.repository.RoomRepository;
import com.myown.springstudies.model.BadRequestException;
import com.myown.springstudies.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    private final RoomRepository roomRepository;

    public RoomsController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public Iterable<RoomEntity> getRooms() {
        return roomRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomEntity addRoom(@RequestBody RoomEntity room) {
        return roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public RoomEntity getRoom(@PathVariable(value = "id") Long id) {
        Optional<RoomEntity> room = roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new NotFoundException("Room with id " + id + " not found");
        }
        return room.get();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoom(@PathVariable(value = "id") Long id, @RequestBody RoomEntity room) {

        if (roomRepository.findById(id).isEmpty()) {
            throw new BadRequestException("Room with id: " + id + " not found");
        }
        roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable(value = "id") Long id) {
        roomRepository.deleteById(id);
    }

}
