package com.ravi.rest.webservices.restfulwebservices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    /*
    Using our created ExceptionResponse class and CustomizeExceptionHandler
    class, we will try to format and make exception response standard
    through our all services.

    Its not required if default exception format given by Spring is ok for us,
    but in case if we want to customize it , we will do it by extending default
    ExceptionHandler, i.e. ResponseEntityExceptionHandler.

    Like suppose, we just want to send exception message, time stamp and some detail
    about any exception that occurred.

    We can achieve this by help of overriding ResponseEntityExceptionHandler methods.
    In our example, we have used CustomizeExceptionHandler class to extend
    ResponseEntityExceptionHandler class and used ExceptionResponse(POJO) class to decide which
    parameters we will be passing.

    If we don't use these two classes, than also Spring will return exception in its own default
    format.
    We can comment out both classes and see difference.

     If Exception Occurs-->

        With ExceptionResponse and CustomizeExceptionHandler:
            {
                "timestamp": "2020-05-30T18:31:51.989+00:00",
                "message": "UserId 8 Doesn't Exist",
                "details": "uri=/user/8"
             }

        Otherwise:
            {
                "timestamp": "2020-05-30T18:35:05.809+00:00",
                "status": 404,
                "error": "Not Found",
                "trace": "com.ravi.rest.webservices.restfulwebservices.Exception.UserNotFoundException: UserId 8\n\tat com.ravi.rest.webservices.restfulwebservices.Controller.UserController.getUser(UserController.java:29)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat
                            .....
                            .....
             }


        Note: If we are depending on our customize exception handler, i.e., CustomizeExceptionHandler.java in this case,
        than, since we are defining there status and response entity to be returned, we can comment out
        @ResponseStatus annotaion from thi class.
     */
}
