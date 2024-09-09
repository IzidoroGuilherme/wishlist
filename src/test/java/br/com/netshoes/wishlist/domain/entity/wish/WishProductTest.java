package br.com.netshoes.wishlist.domain.entity.wish;

import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.WishProductCreateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WishProductTest {
    @Test
    void Should_ThrowException_When_ProductIdIsNullOrBlank() {
        assertThrows(WishProductCreateException.class,
                () -> new WishProduct(null, "111", 2), "Um dos dados obrigatórios não foram passados: [productId, userId e productQuantity]");

        assertThrows(WishProductCreateException.class,
                () -> new WishProduct("", "111", 2), "Um dos dados obrigatórios não foram passados: [productId, userId e productQuantity]");
    }

}
