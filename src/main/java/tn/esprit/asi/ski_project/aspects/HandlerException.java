package tn.esprit.asi.ski_project.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleIllegalArgumentException(IllegalArgumentException e)
    {
        Map<String,String> returnValue = new HashMap<>();
        returnValue.put("error",e.getMessage());
        return returnValue;
    }
}
