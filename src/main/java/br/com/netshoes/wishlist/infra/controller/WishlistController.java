package br.com.netshoes.wishlist.infra.controller;

import br.com.netshoes.wishlist.application.usecases.wish.CreateWishProductUseCase;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.infra.controller.dto.WishProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/wish")
public class WishlistController {
    private final CreateWishProductUseCase createWishProductUseCase;

    public WishlistController(CreateWishProductUseCase createWishProductUseCase) {
        this.createWishProductUseCase = createWishProductUseCase;
    }

    @PostMapping
    public ResponseEntity<WishProductDto> createWishProduct(@RequestBody WishProductDto wishProductRequest, UriComponentsBuilder uriBuilder) {
        WishProduct wishProduct = createWishProductUseCase.saveWishProduct(new WishProduct(wishProductRequest.productId(),
                wishProductRequest.userId(), wishProductRequest.productQuantity()));

        var uri = uriBuilder.path("/wish/{userId}/{productId}").buildAndExpand(wishProduct.getUserId(), wishProduct.getProductId()).toUri();

        return ResponseEntity.created(uri).body(new WishProductDto(wishProduct.getProductId(),
                wishProduct.getUserId(), wishProduct.getProductQuantity()));
    }

}
