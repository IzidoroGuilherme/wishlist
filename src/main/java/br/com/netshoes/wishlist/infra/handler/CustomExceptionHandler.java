package br.com.netshoes.wishlist.infra.handler;

import br.com.netshoes.wishlist.domain.exceptions.NotFoundException;
import br.com.netshoes.wishlist.domain.exceptions.WishListFullException;
import br.com.netshoes.wishlist.domain.exceptions.WishProductCreateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(WishProductCreateException.class)
    private ResponseEntity<ExceptionResponse> wishProductCreateExceptionHandler(WishProductCreateException wishProductCreateException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(new ExceptionResponse(HttpStatus.BAD_REQUEST, wishProductCreateException.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionResponse> notFoundExceptionExceptionHandler(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new ExceptionResponse(HttpStatus.NOT_FOUND, notFoundException.getMessage()));
    }

    @ExceptionHandler(WishListFullException.class)
    private ResponseEntity<ExceptionResponse> notFoundExceptionExceptionHandler(WishListFullException wishListFullException){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).
                body(new ExceptionResponse(HttpStatus.FORBIDDEN, wishListFullException.getMessage()));
    }

}
