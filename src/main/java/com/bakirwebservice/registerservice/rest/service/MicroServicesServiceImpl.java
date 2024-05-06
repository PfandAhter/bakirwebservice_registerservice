package com.bakirwebservice.registerservice.rest.service;

import com.bakirwebservice.registerservice.api.client.UserServiceClient;
import com.bakirwebservice.registerservice.api.request.BaseRequest;
import com.bakirwebservice.registerservice.api.response.GetMicroServicesResponse;
import com.bakirwebservice.registerservice.exception.AccessDeniedException;
import com.bakirwebservice.registerservice.model.dto.MicroServicesDTO;
import com.bakirwebservice.registerservice.rest.repository.MicroServiceRepository;
import com.bakirwebservice.registerservice.rest.service.interfaces.MicroServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor

public class MicroServicesServiceImpl implements MicroServices {

    private final MicroServiceRepository microServiceRepository;

    private final MapperServiceImpl mapperService;

    private final UserServiceClient userServiceClient;

    public GetMicroServicesResponse getMicroServicesResponse(BaseRequest baseRequest) throws AccessDeniedException {
        if (userServiceClient.extractRoleFromToken(baseRequest).equals("ADMIN")) {
            Timestamp timestamp = Timestamp.from(Instant.now());
            return new GetMicroServicesResponse(mapperService.map(microServiceRepository.findMicroServicesByCurrentTimestampBetweenMicroServiceReadyDateAndMicroServiceStoppedDate(timestamp), MicroServicesDTO.class));
        }
        else{
            throw new AccessDeniedException("ACCESS DENIED");
        }
    }

}
