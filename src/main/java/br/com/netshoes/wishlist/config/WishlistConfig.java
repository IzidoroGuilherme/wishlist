package br.com.netshoes.wishlist.config;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.application.usecases.wish.CreateWishProductUseCase;
import br.com.netshoes.wishlist.application.usecases.wish.DeleteWishProductUseCase;
import br.com.netshoes.wishlist.application.usecases.wish.GetUserWishListUseCase;
import br.com.netshoes.wishlist.application.usecases.wish.GetWishProductUseCase;
import br.com.netshoes.wishlist.infra.gateways.MongoDBWishlistRepository;
import br.com.netshoes.wishlist.infra.gateways.WishProductMapper;
import br.com.netshoes.wishlist.infra.persistence.WishlistRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WishlistConfig {
    @Bean
    CreateWishProductUseCase createWishProductUseCase(WishListRepositoryGateway wishListRepositoryGateway){
        return new CreateWishProductUseCase(wishListRepositoryGateway);
    }

    @Bean
    GetUserWishListUseCase getUserWishListUseCase(WishListRepositoryGateway wishListRepositoryGateway){
        return new GetUserWishListUseCase(wishListRepositoryGateway);
    }

    @Bean
    GetWishProductUseCase getWishProductUseCase(WishListRepositoryGateway wishListRepositoryGateway){
        return new GetWishProductUseCase(wishListRepositoryGateway);
    }

    @Bean
    DeleteWishProductUseCase deleteWishProductUseCase(WishListRepositoryGateway wishListRepositoryGateway, GetWishProductUseCase getWishProductUseCase){
        return new DeleteWishProductUseCase(wishListRepositoryGateway, getWishProductUseCase);
    }

    @Bean
    MongoDBWishlistRepository createMongoDBWishlistRepository(WishlistRepository wishlistRepository, WishProductMapper wishProductMapper){
        return new MongoDBWishlistRepository(wishlistRepository, wishProductMapper);
    }

    @Bean
    WishProductMapper createWishProductMapper(){
        return new WishProductMapper();
    }

}
