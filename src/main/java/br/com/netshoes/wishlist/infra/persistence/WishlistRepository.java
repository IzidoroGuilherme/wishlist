package br.com.netshoes.wishlist.infra.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends MongoRepository<WishProductEntity, String> {

    List<WishProductEntity> findAllByUserId(String userId);

    boolean existsByUserIdAndProductId(String userId, String productId);

    long countByUserId(String userId);


}
