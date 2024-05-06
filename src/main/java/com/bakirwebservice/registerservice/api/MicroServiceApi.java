package com.bakirwebservice.registerservice.api;

import com.bakirwebservice.registerservice.api.request.BaseRequest;
import com.bakirwebservice.registerservice.api.response.GetMicroServicesResponse;
import com.bakirwebservice.registerservice.exception.AccessDeniedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MicroServiceApi {
    @PostMapping(path = "dashboard" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetMicroServicesResponse> activeMicroServicesList (@RequestBody BaseRequest baseRequest , HttpServletRequest request) throws AccessDeniedException;

}
