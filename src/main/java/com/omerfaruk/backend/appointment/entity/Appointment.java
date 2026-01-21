package com.omerfaruk.backend.appointment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "appointments")

public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")

    private AppointmentStatus status;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "description")
    private String description;

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }
    public Long getId() {
        return id;
    }

}

