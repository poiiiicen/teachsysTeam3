package com.se.tss.forum.Service;

import com.se.tss.Public.SelectClass.ClassRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassRoomInfoService extends JpaRepository<ClassRoomInfo, String> {

    List<ClassRoomInfo> findByPlaceAndRoomNumber(String place, String roomNumber);


    @Transactional
    @Query(value = "insert into classroom values(?1, ?2, ?3, ?4)",nativeQuery=true)
    @Modifying
    void doInsert(String place, String roomNumber, int capacity,String equipment);

    @Transactional
    @Query(value = "delete classroom where place=?1 and roomNumber=?2",nativeQuery=true)
    @Modifying
    void doDelete(String place, String roomNumber);

    @Transactional
    @Query(value = "update classroom set capacity = ?3, equipment = ?4 where place =?1 and roomNumber = ?2",nativeQuery=true)
    @Modifying
    void doUpdate(String place, String roomNumber, int capacity,String equipment);
}
