package com.dario.ift.api.v1.controller.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class HttpErrorDto {
    String timestamp;
    String status;
    String error;
    String path;
}
