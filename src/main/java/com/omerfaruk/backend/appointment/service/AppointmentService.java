package com.omerfaruk.backend.appointment.service;

import com.omerfaruk.backend.appointment.dto.request.CreateAppointmentRequest;
import java.util.List;
import com.omerfaruk.backend.appointment.dto.response.AppointmentResponse;
public interface AppointmentService {
    AppointmentResponse create(CreateAppointmentRequest request);
    AppointmentResponse cancel(Long id);


    List<AppointmentResponse> getAll();
    AppointmentResponse getById(Long id);

}
