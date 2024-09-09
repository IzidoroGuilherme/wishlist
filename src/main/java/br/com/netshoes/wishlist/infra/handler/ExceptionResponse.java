package br.com.netshoes.wishlist.infra.handler;

import org.springframework.http.HttpStatus;

record ExceptionResponse(HttpStatus status,
                         String message) {
}
