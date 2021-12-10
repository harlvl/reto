package pe.entelgy.reto.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

public class RestResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<String> data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;


    public RestResponse() {
        data = new ArrayList<>();
    }

    public RestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestResponse(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
