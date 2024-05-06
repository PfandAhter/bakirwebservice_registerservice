package com.bakirwebservice.registerservice.api.response;

import com.bakirwebservice.registerservice.model.dto.MicroServicesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class GetMicroServicesResponse {

    List<MicroServicesDTO> microServicesDTOList;
}
