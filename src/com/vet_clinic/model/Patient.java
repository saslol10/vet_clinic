package com.vet_clinic.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 * javadoc
 * Patient class
 * @autor Kamila LoL
 * @version 1.0
 */

public class Patient {

    //fields
    private final int id; //id

    private String surname; // ФИО
    private String name;
    private String middleName;

    private final String registrationDate; // дата регистрации yyyy-mm-dd

    //Constructor
    public Patient(int id, String surname, String name, String middleName) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;

        String formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now()); //форматирование даты
        registrationDate = formatter;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(surname, patient.surname) && Objects.equals(name, patient.name) && Objects.equals(middleName, patient.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, middleName);
    }
}
