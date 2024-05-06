package com.bakirwebservice.registerservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FindMicroServicesRequest extends BaseRequest {

    private String startsDate;

    private String stoppedDate;
}
