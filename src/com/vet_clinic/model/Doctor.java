package com.vet_clinic.model;

import java.time.Instant;
import java.util.Objects;

/**
 * javadoc
 * Doctor class
 * @autor Kamila LoL
 * @version 1.0
 */

public class Doctor {

    //fields
    private final int id; //id
    private final String name; // ФИО

    //Constructor
    public Doctor(int id, String name){
        this.id = id;
        this.name = name;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
