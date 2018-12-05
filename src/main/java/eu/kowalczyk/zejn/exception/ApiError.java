package eu.kowalczyk.zejn.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by JKowalczyk on 2017-09-15.
 */
@Getter
@Setter
class ApiError {
    private String faultString;
    private String faultCode;

    public ApiError(String faultString, String faultCode) {
        this.faultString = faultString;
        this.faultCode = faultCode;
    }

    @Override
    public String toString() {
        return "faultString: " + faultString + ", faultCode: " + faultCode;
    }
}

