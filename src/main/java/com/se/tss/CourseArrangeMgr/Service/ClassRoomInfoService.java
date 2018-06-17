package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassRoomInfoService extends JpaRepository<ClassRoomInfo, String> {

    List<ClassRoomInfo> findALLByPlaceAndRoomNumber(String place, String roomNumber);


    @Transactional
    @Query(value = "insert into classroom(place,roomNumber,capacity,equipment,room_number) values(?1, ?2, ?3, ?4,0)",nativeQuery=true)
    @Modifying
    void doInsert(String place, String roomNumber, int capacity,String equipment);

    @Transactional
    @Query(value = "delete from classroom where place=?1 and roomNumber=?2",nativeQuery=true)
    @Modifying
    void doDelete(String place, String roomNumber);

    @Transactional
    @Query(value = "update classroom set capacity = ?3, equipment = ?4 where place =?1 and roomNumber = ?2",nativeQuery=true)
    @Modifying
    void doUpdate(String place, String roomNumber, int capacity,String equipment);
}
