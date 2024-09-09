package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;

public class DeleteWishProductUseCase {
    private final WishListRepositoryGateway wishListRepositoryGateway;
    private final GetWishProductUseCase getWishProductUseCase;
    public DeleteWishProductUseCase(WishListRepositoryGateway wishListRepositoryGateway,
                                    GetWishProductUseCase getWishProductUseCase) {
        this.wishListRepositoryGateway = wishListRepositoryGateway;
        this.getWishProductUseCase = getWishProductUseCase;

    }

    public void deleteWishProduct(String userId, String productId){
        WishProduct wishProduct = getWishProductUseCase.getWishProductByUserIdAndProductId(userId, productId);
        wishListRepositoryGateway.deleteWishProduct(wishProduct);
    }
}
