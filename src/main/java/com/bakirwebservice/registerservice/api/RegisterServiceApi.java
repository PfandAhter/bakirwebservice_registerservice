package com.bakirwebservice.registerservice.api;

import com.bakirwebservice.registerservice.api.request.MicroServiceReadyRequest;
import com.bakirwebservice.registerservice.api.request.MicroServiceStoppedRequest;
import com.bakirwebservice.registerservice.api.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RegisterServiceApi {

    @PostMapping(path = "ready" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> microServiceRegister (@RequestBody MicroServiceReadyRequest microServiceReadyRequest , HttpServletRequest request);

    @PostMapping(path = "stopped" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> microServiceRegister (@RequestBody MicroServiceStoppedRequest microServiceStoppedRequest , HttpServletRequest request);


}
