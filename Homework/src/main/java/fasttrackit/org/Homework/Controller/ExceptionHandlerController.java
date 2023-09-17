package fasttrackit.org.Homework.Controller;

import fasttrackit.org.Homework.Exceptions.ApiException;
import fasttrackit.org.Homework.Exceptions.EntityAlreadyExistsException;
import fasttrackit.org.Homework.Exceptions.EntityDoesntExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiException handleConflict(EntityAlreadyExistsException exception) {
        return new ApiException(exception.getMessage(), exception.getEntityId(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityDoesntExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiException handleNotFound(EntityDoesntExistException exception) {
        return new ApiException(exception.getMessage(), exception.getEntityId(), HttpStatus.NOT_FOUND);
    }
}
