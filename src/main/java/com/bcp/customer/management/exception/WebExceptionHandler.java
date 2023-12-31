package com.bcp.customer.management.exception;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
@Order(-1) //Ordered.HIGHEST_PRECEDENCE
public class WebExceptionHandler extends AbstractErrorWebExceptionHandler {

    public WebExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources,
                               ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
        super(errorAttributes, resources, applicationContext);
        this.setMessageWriters(configurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse); //req -> this.renderErrorResponse(req)
    }

    private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String, Object> generalError = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        Map<String, Object> customError = new HashMap<>();

        //HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        var status = HttpStatus.UNAUTHORIZED;
        String statusCode = String.valueOf(generalError.get("status"));
        Throwable error = getError(request); //Obtienes la excepcion de la peticion

        //switch enhanced
        switch (statusCode){
            case "400":
                customError.put("message", error.getMessage());
                customError.put("status", 400);
                status = HttpStatus.UNAUTHORIZED;
                break;
            case "404" :
                customError.put("message", error.getMessage());
                customError.put("status", 404);
                status = HttpStatus.UNAUTHORIZED;
                break;
                case "401" :
                customError.put("message", error.getMessage());
                customError.put("status", 401);
                status = HttpStatus.UNAUTHORIZED;
                break;
                case "500" :
                customError.put("message", error.getMessage());
                customError.put("status", 500);
                break;
        }

        return ServerResponse.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customError));
    }
}
