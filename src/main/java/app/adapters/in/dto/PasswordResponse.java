package app.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordResponse {

    public PasswordResponse(boolean isValid, String password){
        this.isValid = isValid;
    }

    @JsonProperty("isPasswordValid")
    private boolean isValid;

}
