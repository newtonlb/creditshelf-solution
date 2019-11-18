package com.creditshelf.solution.model;

import java.util.Objects;

public class ResponseDTO {
    public Object response;

    public ResponseDTO() {
    }

    public ResponseDTO(Object response) {
        this.response = response;
    }

    public Object getResponse() {
        return this.response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public ResponseDTO response(Object response) {
        this.response = response;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResponseDTO)) {
            return false;
        }
        ResponseDTO responseDTO = (ResponseDTO) o;
        return Objects.equals(response, responseDTO.response);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(response);
    }

    @Override
    public String toString() {
        return "{" +
            " response='" + getResponse() + "'" +
            "}";
    }
}
