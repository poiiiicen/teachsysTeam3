package com.se.tss.Public.SelectClass;

import sun.security.util.Length;

import javax.persistence.*;

@Entity
@Table(name="classroom")
public class ClassRoomInfo {

    @Id
    @GeneratedValue
    private Integer cid;

    @Column(length=64, nullable = false)
    private String place;

    @Column(length=64, nullable = false)
    private String roomNumber;

    @Column()
    private int capacity;

    @Column(length=64, nullable = true)
    private String  equipment;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
