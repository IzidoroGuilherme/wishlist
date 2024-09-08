package br.com.netshoes.wishlist.domain.exceptions;

public class WishListFullException extends RuntimeException{
    public WishListFullException(String message) {
        super(message);
    }
}
