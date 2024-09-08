package br.com.netshoes.wishlist.infra.gateways;

import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.infra.persistence.WishProductEntity;

public class WishProductMapper {
    public WishProductEntity toEntity(WishProduct wishProduct) {
        return new WishProductEntity(wishProduct.getProductId(), wishProduct.getUserId(),
                wishProduct.getProductQuantity());
    }

    public WishProduct toDomain(WishProductEntity wishProductEntity){
        return new WishProduct(wishProductEntity.getProductId(), wishProductEntity.getUserId(), wishProductEntity.getProductQuantity());
    }
}
