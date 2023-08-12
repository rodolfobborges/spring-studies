package com.myown.springstudies.data.repository;

import com.myown.springstudies.data.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
}
