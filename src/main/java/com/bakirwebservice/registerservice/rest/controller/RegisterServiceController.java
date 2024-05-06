package com.bakirwebservice.registerservice.rest.controller;

import com.bakirwebservice.registerservice.api.RegisterServiceApi;
import com.bakirwebservice.registerservice.api.request.MicroServiceReadyRequest;
import com.bakirwebservice.registerservice.api.request.MicroServiceStoppedRequest;
import com.bakirwebservice.registerservice.api.response.BaseResponse;
import com.bakirwebservice.registerservice.rest.service.RegisterServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registerservice")
@RequiredArgsConstructor
@Slf4j

public class RegisterServiceController implements RegisterServiceApi {

    private final RegisterServiceImpl registerService;

    @Override
    public ResponseEntity<BaseResponse> microServiceRegister(MicroServiceReadyRequest microServiceReadyRequest, HttpServletRequest request) {
        return ResponseEntity.ok(registerService.microServiceRegister(microServiceReadyRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> microServiceRegister(MicroServiceStoppedRequest microServiceStoppedRequest, HttpServletRequest request) {
        return ResponseEntity.ok(registerService.microServiceStopped(microServiceStoppedRequest));
    }

}
