package br.com.netshoes.wishlist.infra.controller;

import br.com.netshoes.wishlist.application.usecases.wish.CreateWishProductUseCase;
import br.com.netshoes.wishlist.application.usecases.wish.DeleteWishProductUseCase;
import br.com.netshoes.wishlist.application.usecases.wish.GetUserWishListUseCase;
import br.com.netshoes.wishlist.application.usecases.wish.GetWishProductUseCase;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.infra.controller.dto.WishProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/wish")
public class WishlistController {
    private final CreateWishProductUseCase createWishProductUseCase;
    private final GetUserWishListUseCase getUserWishListUseCase;
    private final GetWishProductUseCase getWishProductUseCase;
    private final DeleteWishProductUseCase deleteWishProductUseCase;

    public WishlistController(CreateWishProductUseCase createWishProductUseCase, GetUserWishListUseCase getUserWishListUseCase,
                              GetWishProductUseCase getWishProductUseCase, DeleteWishProductUseCase deleteWishProductUseCase) {
        this.createWishProductUseCase = createWishProductUseCase;
        this.getUserWishListUseCase = getUserWishListUseCase;
        this.getWishProductUseCase = getWishProductUseCase;
        this.deleteWishProductUseCase = deleteWishProductUseCase;
    }

    @PostMapping
    public ResponseEntity<WishProductDto> createWishProduct(@RequestBody WishProductDto wishProductRequest, UriComponentsBuilder uriBuilder) {
        WishProduct wishProduct = createWishProductUseCase.saveWishProduct(new WishProduct(wishProductRequest.productId(),
                wishProductRequest.userId(), wishProductRequest.productQuantity()));

        var uri = uriBuilder.path("/wish/{userId}/{productId}").buildAndExpand(wishProduct.getUserId(), wishProduct.getProductId()).toUri();

        return ResponseEntity.created(uri).body(new WishProductDto(wishProduct.getProductId(),
                wishProduct.getUserId(), wishProduct.getProductQuantity()));
    }

    @GetMapping("/{userId}")
    public List<WishProductDto> getUserWishList(@PathVariable String userId){
        return getUserWishListUseCase.getUserWishlist(userId).stream().map(wishProduct -> new WishProductDto(wishProduct.getProductId(),
                wishProduct.getUserId(), wishProduct.getProductQuantity())).toList();
    }

    @GetMapping("/{userId}/{productId}")
    public WishProductDto getWishlistProduct(@PathVariable String userId, @PathVariable String productId){
        WishProduct wishProduct = getWishProductUseCase.getWishProductByUserIdAndProductId(userId,productId);
        return new WishProductDto(wishProduct.getProductId(), wishProduct.getUserId(), wishProduct.getProductQuantity());
    }

    @DeleteMapping("/{userId}/{productId}")
    public void deleteWishProduct(@PathVariable String userId, @PathVariable String productId){
        deleteWishProductUseCase.deleteWishProduct(userId,productId);
    }

}
