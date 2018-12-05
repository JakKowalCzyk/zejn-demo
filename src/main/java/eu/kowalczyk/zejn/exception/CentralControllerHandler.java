package eu.kowalczyk.zejn.exception;

import eu.kowalczyk.zejn.person.dto.PersonNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

/**
 * Created by JKowalczyk on 2017-09-15.
 */
@ControllerAdvice
class CentralControllerHandler {
    final static private Logger logger = LoggerFactory.getLogger(CentralControllerHandler.class);

    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                setValue(new Timestamp(Long.parseLong(value)));
            }
        });
    }

    @ExceptionHandler({BindException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError bindException(BindException e, Locale locale) {
        List<ObjectError> allErrors = e.getAllErrors();
        ObjectError error = allErrors.get(0);
        logError(e);
        String type = StringUtils.substringBefore(error.getDefaultMessage(), "|");
        String message = StringUtils.substringAfter(error.getDefaultMessage(), "|");

        return new ApiError(message, type);
    }

    @ExceptionHandler({ValidationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ApiError validationException(ValidationException e, Locale locale) {
        logError(e);
        return new ApiError(e.getMessage(), "REQUEST_ARGUMENTS_NOT_VALID");
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError missingServletRequestParameterException(MissingServletRequestParameterException e, Locale locale) {
        logError(e);
        return new ApiError(e.getMessage(), "ERR_API_REQUEST");
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError exception(Exception e, Locale locale) {
        logError(e);
        return new ApiError("UNEXPECTED_ERROR", "ERR_SERVER");
    }

    @ExceptionHandler({PersonNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError clientNotFoundException(PersonNotFoundException e, Locale locale) {
        logError(e);
        return new ApiError(e.getMessage(), "PERSON_NOT_FOUND");
    }


    public <T extends Exception> void logError(T e) {
        logger.error(String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage()));
    }

}