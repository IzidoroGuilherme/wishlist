package br.com.netshoes.wishlist.infra.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("Wishlist")
public class WishProductEntity {

    @Id
    private String wishProductId;

    private String productId;

    private String userId;
    private Integer productQuantity;

    private LocalDateTime createDateTime = LocalDateTime.now();

    public WishProductEntity() {}

    public WishProductEntity(String productId, String userId, Integer productQuantity) {
        this.productId = productId;
        this.userId = userId;
        this.productQuantity = productQuantity;
    }

    public String getWishProductId() {
        return wishProductId;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }
}
