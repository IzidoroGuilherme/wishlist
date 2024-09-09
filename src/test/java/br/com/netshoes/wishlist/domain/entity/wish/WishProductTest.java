package br.com.netshoes.wishlist.domain.entity.wish;

import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.WishProductCreateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WishProductTest {
    @Test
    void Should_ThrowException_When_ProductIdIsNullOrBlank() {
        Assertions.assertThrows(WishProductCreateException.class,
                () -> new WishProduct(null, "111", 2), "Um dos dados obrigatórios não foram passado: [productId, userId e productQuantity]");

        Assertions.assertThrows(WishProductCreateException.class,
                () -> new WishProduct("", "111", 2), "Um dos dados obrigatórios não foram passado: [productId, userId e productQuantity]");
    }

}
