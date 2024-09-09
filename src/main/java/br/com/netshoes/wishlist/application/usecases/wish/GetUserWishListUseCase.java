package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;

import java.util.List;

public class GetUserWishListUseCase {
    private final WishListRepositoryGateway wishListRepository;

    public GetUserWishListUseCase(WishListRepositoryGateway wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public List<WishProduct> getUserWishlist(String userId){
        return wishListRepository.getWishListByUserId(userId);
    }
}
