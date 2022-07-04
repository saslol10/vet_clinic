package com.vet_clinic.model;

import java.util.Objects;

/**
 * javadoc
 * Appointment class
 * @autor Kamila LoL
 * @version 1.0
 */

public class Appointment {

    //fields
    private String status; // Статус: Новый; В процессе; Отменен; Ожидает оплаты; Завершен;
    private final String appointmentDate; // дата и время приема yyyy-mm-dd_HH:mm - стоит добавить проверку ввода -> todo
    //так же стоит добавить проверку на повторение даты у разных пациентов к одному доктору на одно время -> todo
    private final int patientId;
    private final int doctorId;

    //Constructors
    public Appointment(int patientId, int doctorId, String appointmentDate){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = "Новый ";
    }

    public Appointment(int patientId, int doctorId, String appointmentDate, String status){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    //Getters and Setters
    public Integer getPatientId() {
        return patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(doctorId, that.doctorId) && Objects.equals(appointmentDate, that.appointmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, doctorId, appointmentDate);
    }
}
