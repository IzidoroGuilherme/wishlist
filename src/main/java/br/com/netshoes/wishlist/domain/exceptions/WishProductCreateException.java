package br.com.netshoes.wishlist.domain.exceptions;

public class WishProductCreateException extends RuntimeException{

    public WishProductCreateException(String message) {
        super(message);
    }
}
