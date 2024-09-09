package br.com.netshoes.wishlist.infra.persistence;

import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends MongoRepository<WishProductEntity, String> {

    List<WishProductEntity> findAllByUserId(String userId);

    WishProduct findByUserIdAndProductId(String userId, String productId);

    boolean existsByUserIdAndProductId(String userId, String productId);

    long countByUserId(String userId);


}
