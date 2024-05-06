package com.bakirwebservice.registerservice.rest.controller;

import com.bakirwebservice.registerservice.api.MicroServiceApi;
import com.bakirwebservice.registerservice.api.request.BaseRequest;
import com.bakirwebservice.registerservice.api.response.GetMicroServicesResponse;
import com.bakirwebservice.registerservice.exception.AccessDeniedException;
import com.bakirwebservice.registerservice.rest.service.MicroServicesServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("microservices")
@RequiredArgsConstructor
@Slf4j

public class MicroServiceController implements MicroServiceApi {

    private final MicroServicesServiceImpl microServicesService;


    @Override
    public ResponseEntity<GetMicroServicesResponse> activeMicroServicesList(BaseRequest baseRequest, HttpServletRequest request)throws AccessDeniedException {
        return ResponseEntity.ok(microServicesService.getMicroServicesResponse(baseRequest));
    }
}
