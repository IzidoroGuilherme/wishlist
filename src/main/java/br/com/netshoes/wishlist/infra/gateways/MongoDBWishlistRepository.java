package br.com.netshoes.wishlist.infra.gateways;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.infra.persistence.WishProductEntity;
import br.com.netshoes.wishlist.infra.persistence.WishlistRepository;

import java.util.List;

public class MongoDBWishlistRepository implements WishListRepositoryGateway {

    private final WishlistRepository repository;
    private final WishProductMapper wishProductMapper;

    public MongoDBWishlistRepository(WishlistRepository repository, WishProductMapper wishProductMapper) {
        this.repository = repository;
        this.wishProductMapper = wishProductMapper;
    }

    @Override
    public WishProduct saveWishProduct(WishProduct wishProduct) {
        WishProductEntity wishProductEntity = wishProductMapper.toEntity(wishProduct);
        return wishProductMapper.toDomain(repository.save(wishProductEntity));
    }

    @Override
    public boolean existsWishProduct(String userId, String productId) {
        return repository.existsByUserIdAndProductId(userId,productId);
    }

    @Override
    public long wishListSizeByUserId(String userId){
        return repository.countByUserId(userId);
    }

    @Override
    public List<WishProduct> getWishListByUserId(String userId) {
        return repository.findAllByUserId(userId).stream().map(wishProductMapper::toDomain).toList();
    }

    @Override
    public WishProduct getWishProductByUserIdAndProductId(String userId, String productId) {
        return repository.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public void deleteWishProduct(WishProduct wishProduct){
        WishProductEntity wishProductEntity = wishProductMapper.toEntity(wishProduct);
        repository.delete(wishProductEntity);
    }


}
