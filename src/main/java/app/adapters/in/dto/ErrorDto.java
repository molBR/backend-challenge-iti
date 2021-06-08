package app.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorDto {

    public ErrorDto(List<String> listOfError, String error){
        this.listOfError = listOfError;
        this.error = error;
        this.isValidPassword = false;
    }

    @JsonProperty("list_of_errors")
    List<String> listOfError;

    @JsonProperty("error_message")
    String error;

    @JsonProperty("isPasswordValid")
    private boolean isValidPassword;

}
