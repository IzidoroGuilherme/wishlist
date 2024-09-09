package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.NotFoundException;

public class GetWishProductUseCase {
    private final WishListRepositoryGateway wishListRepositoryGateway;

    public GetWishProductUseCase(WishListRepositoryGateway wishListRepositoryGateway) {
        this.wishListRepositoryGateway = wishListRepositoryGateway;
    }

    public WishProduct getWishProductByUserIdAndProductId(String userId, String productId){
        WishProduct wishProduct = wishListRepositoryGateway.getWishProductByUserIdAndProductId(userId, productId);
        if (wishProduct == null) {
            throw new NotFoundException();
        }

        return wishProduct;
    }
}
