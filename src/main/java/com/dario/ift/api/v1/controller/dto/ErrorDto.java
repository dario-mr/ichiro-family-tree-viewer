package com.dario.ift.api.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDto {
    private String summary;
    private String description;
}
