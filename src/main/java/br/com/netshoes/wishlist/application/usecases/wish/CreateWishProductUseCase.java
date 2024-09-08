package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.WishListFullException;
import br.com.netshoes.wishlist.domain.exceptions.WishProductCreateException;

public class CreateWishProductUseCase {
    private final WishListRepositoryGateway wishListRepository;
    private static final int WISH_LIST_LIMIT_SIZE = 25;

    public CreateWishProductUseCase(WishListRepositoryGateway wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public WishProduct saveWishProduct(WishProduct wishProduct){
        if (wishListRepository.existsWishProduct(wishProduct.getUserId(), wishProduct.getProductId())){
            throw new WishProductCreateException("Este produto já se encontra na sua lista de desejos");
        }

        if (wishListRepository.wishListSizeByUserId(wishProduct.getUserId()) >= WISH_LIST_LIMIT_SIZE){
            throw new WishListFullException("Sua lista de desejo está cheia");
        }

        return wishListRepository.saveWishProduct(wishProduct);
    }
}
