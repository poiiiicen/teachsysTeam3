package com.se.tss.CourseArrangeMgr.Dao;

import javax.persistence.*;

@Entity
@Table(name="classroom")
public class ClassRoomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(length=20,nullable  =false)
    private String id;

    @Column(length=64, nullable = false)
    private String place;

    @Column(length=64, nullable = false)
    private String roomnumber;

    @Column()
    private int capacity;

    @Column(length=64, nullable = true)
    private String  equipment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
