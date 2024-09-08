package br.com.netshoes.wishlist.infra.controller.dto;

public record WishProductDto(
        String productId,
        String userId,
        Integer productQuantity
) {
}
