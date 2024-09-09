package br.com.netshoes.wishlist.domain.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Produto não se encontra na lista de desejos");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
