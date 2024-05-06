package com.bakirwebservice.registerservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "microservices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MicroService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "microservice_id")
    private String microServiceId;

    @Column(name = "microservice_code")
    private String microServiceCode;

    @Column(name = "microservice_error_code")
    private String microServiceErrorCode;

    @Column(name = "microservice_name")
    private String microServiceName;

    @Column(name = "microservice_ready_date")
    private Timestamp microServiceReadyDate;

    @Column(name = "microservice_stopped_date")
    private Timestamp microServiceStoppedDate;

    @Column(name = "microservice_status")
    private String microServiceStatus;

}
