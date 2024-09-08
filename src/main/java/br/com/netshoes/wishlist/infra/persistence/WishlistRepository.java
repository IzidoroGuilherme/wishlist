package br.com.netshoes.wishlist.infra.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends MongoRepository<WishProductEntity, String> {
    boolean existsByUserIdAndProductId(String userId, String productId);

    long countByUserId(String userId);
}
