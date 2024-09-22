package com.ccallazans.springlambda.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        @JsonProperty("email")
        String email
) {
}
