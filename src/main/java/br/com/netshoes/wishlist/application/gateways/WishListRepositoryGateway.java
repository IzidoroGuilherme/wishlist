package br.com.netshoes.wishlist.application.gateways;

import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;

import java.util.List;

public interface WishListRepositoryGateway {
    WishProduct saveWishProduct(WishProduct wishProduct);

    boolean existsWishProduct(String userId, String productId);

    long wishListSizeByUserId(String userId);

    WishProduct getWishProductByUserIdAndProductId(String userId, String productId);

    List<WishProduct> getWishListByUserId(String userId);

    void deleteWishProduct(WishProduct wishProduct);

}
