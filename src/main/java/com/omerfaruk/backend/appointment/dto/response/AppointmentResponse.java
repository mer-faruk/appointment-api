package com.omerfaruk.backend.appointment.dto.response;

import com.omerfaruk.backend.appointment.entity.AppointmentStatus;

public class AppointmentResponse {

    private Long id;
    private String customerName;
    private String description;
    private AppointmentStatus status;

    public AppointmentResponse(
            Long id,
            String customerName,
            String description,
            AppointmentStatus status
    ) {
        this.id = id;
        this.customerName = customerName;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDescription() {
        return description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }
}
