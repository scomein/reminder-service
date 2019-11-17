package com.scomein.reminder.service.api.model.auth;

import com.scomein.reminder.service.api.model.ApiConstants;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {

    @Email
    @NotNull(message = ApiConstants.EMPTY_FIELD_ERROR_MESSAGE)
    private String email;

    @Size(min = 5, max = 50)
    private String password;
}
