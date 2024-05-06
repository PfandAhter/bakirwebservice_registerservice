package com.bakirwebservice.registerservice.rest.service;

import com.bakirwebservice.registerservice.api.request.MicroServiceReadyRequest;
import com.bakirwebservice.registerservice.api.request.MicroServiceStoppedRequest;
import com.bakirwebservice.registerservice.api.response.BaseResponse;
import com.bakirwebservice.registerservice.model.entity.MicroService;
import com.bakirwebservice.registerservice.rest.repository.MicroServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class RegisterServiceImpl {

    private final MicroServiceRepository microServiceRepository;

    private final MapperServiceImpl mapperService;


    public BaseResponse microServiceRegister (MicroServiceReadyRequest request){
        MicroService localMicroService = mapperService.map(request,MicroService.class);
        microServiceRepository.save(localMicroService);
        return new BaseResponse();
    }

    public BaseResponse microServiceStopped (MicroServiceStoppedRequest request){
        MicroService localMicroService = microServiceRepository.findMicroServiceByMicroServiceCode(request.getMicroServiceCode());
        localMicroService.setMicroServiceStoppedDate(request.getMicroServiceStoppedDate());
        localMicroService.setMicroServiceStatus(request.getMicroServiceStatus());
        microServiceRepository.save(localMicroService);

        return new BaseResponse();
    }



}

