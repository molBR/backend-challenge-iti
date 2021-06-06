package app.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PasswordRequest {


    @NotBlank(message = "Password is mandatory")
    @JsonProperty("password")
    private String password;


    public String getPassword(){
        return password;
    }
    public void setPassword(String password){ this.password = password;}
}
