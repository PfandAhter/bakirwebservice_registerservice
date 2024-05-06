package com.bakirwebservice.registerservice.rest.config;

import com.bakirwebservice.registerservice.api.request.MicroServiceReadyRequest;
import com.bakirwebservice.registerservice.api.request.MicroServiceStoppedRequest;
import com.bakirwebservice.registerservice.model.entity.MicroService;
import com.bakirwebservice.registerservice.rest.repository.MicroServiceRepository;
import com.bakirwebservice.registerservice.rest.util.Util;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Component
@Slf4j
@RequiredArgsConstructor
public class MicroServiceRegister {

    private String microServiceCode;

    private static final String microServiceName = "REGISTER-SERVICE";

    private final MicroServiceRepository microServiceRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void logToDataBaseServiceReady(){
        microServiceCode = Util.generateCode();

        microServiceRepository.save(MicroService.builder()
                .microServiceCode(microServiceCode)
                .microServiceStatus("UP")
                .microServiceErrorCode("99000")
                .microServiceReadyDate(Timestamp.from(Instant.now()))
                .microServiceName(microServiceName)
                .build());
    }

    @PreDestroy
    public void testLogToDatabaseStopped(){
        MicroService localMicroService = microServiceRepository.findMicroServiceByMicroServiceCode(microServiceCode);
        localMicroService.setMicroServiceStatus("DOWN");
        localMicroService.setMicroServiceStoppedDate(Timestamp.from(Instant.now()));
        microServiceRepository.save(localMicroService);
    }
}
