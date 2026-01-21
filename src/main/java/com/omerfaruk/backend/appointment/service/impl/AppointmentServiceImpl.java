package com.omerfaruk.backend.appointment.service.impl;

import com.omerfaruk.backend.appointment.entity.Appointment;
import com.omerfaruk.backend.appointment.entity.AppointmentStatus;
import com.omerfaruk.backend.appointment.service.AppointmentService;
import org.springframework.stereotype.Service;
import com.omerfaruk.backend.appointment.repository.AppointmentRepository;
import com.omerfaruk.backend.appointment.exception.BusinessException;
import com.omerfaruk.backend.appointment.dto.request.CreateAppointmentRequest;
import com.omerfaruk.backend.appointment.dto.response.AppointmentResponse;
import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public AppointmentResponse create(CreateAppointmentRequest request) {
        Appointment appointment = new Appointment();
        appointment.setCustomerName(request.getCustomerName());
        appointment.setDescription(request.getDescription());
        appointment.setStatus(AppointmentStatus.CREATED);

        appointmentRepository.save(appointment);

        return new AppointmentResponse(
                appointment.getId(),
                appointment.getCustomerName(),
                appointment.getDescription(),
                appointment.getStatus()
        );
    }

    @Override
    public AppointmentResponse cancel(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Randevu bulunamadı"));

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new BusinessException("Randevu zaten iptal edildi");
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepository.save(appointment);

        return new AppointmentResponse(
                appointment.getId(),
                appointment.getCustomerName(),
                appointment.getDescription(),
                appointment.getStatus()
        );
    }

    @Override
    public List<AppointmentResponse> getAll() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> new AppointmentResponse(
                        appointment.getId(),
                        appointment.getCustomerName(),
                        appointment.getDescription(),
                        appointment.getStatus()
                ))
                .toList();
    }
    @Override
    public AppointmentResponse getById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Randevu bulunamadı"));

        return new AppointmentResponse(
                appointment.getId(),
                appointment.getCustomerName(),
                appointment.getDescription(),
                appointment.getStatus()
        );
    }



    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

}
