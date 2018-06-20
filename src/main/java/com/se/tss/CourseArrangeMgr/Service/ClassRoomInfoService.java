package com.se.tss.CourseArrangeMgr.Service;

import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassRoomInfoService extends JpaRepository<ClassRoomInfo, String> {

    List<ClassRoomInfo> findByPlace(String place);

    List<ClassRoomInfo> findByPlaceNot(String place);

    List<ClassRoomInfo> findAllById(String id);

    ClassRoomInfo findOneById(String id);

    ClassRoomInfo findOneByPlaceAndRoomnumber(String place, String roomNumber);

    @Transactional
    @Query(value = "insert into classroom(id,place,roomnumber,capacity,equipment) values(?1, ?2, ?3, ?4,?5)",nativeQuery=true)
    @Modifying
    void doInsert(String id,String place, String roomNumber, int capacity, String equipment);

    @Transactional
    @Query(value = "delete from classroom where place=?1 and roomnumber=?2",nativeQuery=true)
    @Modifying
    void doDelete(String place, String roomNumber);

    @Query(value = "select id from classroom where  place= ?1 and roomnumber=?2 limit 1",nativeQuery=true)
    String getIdByPlaceAndRoomNumber(String place,String roomnumber);

}
