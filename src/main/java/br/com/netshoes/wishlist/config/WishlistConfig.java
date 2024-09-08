package br.com.netshoes.wishlist.config;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.application.usecases.wish.CreateWishProductUseCase;
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
    MongoDBWishlistRepository createMongoDBWishlistRepository(WishlistRepository wishlistRepository, WishProductMapper wishProductMapper){
        return new MongoDBWishlistRepository(wishlistRepository, wishProductMapper);
    }

    @Bean
    WishProductMapper createWishProductMapper(){
        return new WishProductMapper();
    }

}
