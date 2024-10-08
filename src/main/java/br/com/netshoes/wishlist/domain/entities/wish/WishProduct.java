package br.com.netshoes.wishlist.domain.entities.wish;

import br.com.netshoes.wishlist.domain.exceptions.WishProductCreateException;

public class WishProduct {

    private String wishProductId;
    private final String productId;

    private final String userId;
    private final Integer productQuantity;

    public WishProduct(String productId, String userId, Integer productQuantity) {
        if (isBlankOrNullString(productId) || isBlankOrNullString(userId) || productQuantity == null){
            throw new WishProductCreateException("Um dos dados obrigatórios não foram passados: [productId, userId e productQuantity]");
        }
        this.productId = productId;
        this.userId = userId;
        this.productQuantity = productQuantity;
    }

    private boolean isBlankOrNullString(String string){
        return string == null || string.isBlank();
    }

    public String getWishProductId() {
        return wishProductId;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setWishProductId(String wishProductId) {
        this.wishProductId = wishProductId;
    }
}
