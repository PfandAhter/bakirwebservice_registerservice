package com.bakirwebservice.registerservice.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter

public class MicroServicesDTO {

    private String microServiceCode;

    private String microServiceName;

    private Timestamp microServiceReadyDate;

    private Timestamp microServiceStoppedDate;

    private String microServiceStatus;
}
