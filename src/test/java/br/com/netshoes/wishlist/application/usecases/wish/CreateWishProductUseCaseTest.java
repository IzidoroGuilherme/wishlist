package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.WishListFullException;
import br.com.netshoes.wishlist.domain.exceptions.WishProductCreateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateWishProductUseCaseTest {
    @InjectMocks
    CreateWishProductUseCase createWishProductUseCase;

    @Mock
    WishListRepositoryGateway wishListRepository;

    @Test
    void Should_ReturnWishProduct_When_Sucess(){
        WishProduct wishProduct = new WishProduct("123", "userID", 2);
        when(wishListRepository.existsWishProduct(anyString(),anyString())).thenReturn(false);
        when(wishListRepository.wishListSizeByUserId(anyString())).thenReturn(10L);
        when(wishListRepository.saveWishProduct(wishProduct)).thenReturn(wishProduct);

        WishProduct wishProductResult = createWishProductUseCase.saveWishProduct(wishProduct);
        assertEquals(wishProduct, wishProductResult);
    }

    @Test
    void Should_ThrowException_When_ExistsWishProductTrue(){
        WishProduct wishProduct = new WishProduct("123", "userID", 2);
        when(wishListRepository.existsWishProduct(anyString(),anyString())).thenReturn(true);

        assertThrows(WishProductCreateException.class, () -> createWishProductUseCase.saveWishProduct(wishProduct), "Este produto já se encontra na sua lista de desejos");
    }

    @Test
    void Should_ThrowException_When_UserWishListIsEquals25(){
        WishProduct wishProduct = new WishProduct("123", "userID", 2);
        when(wishListRepository.existsWishProduct(anyString(),anyString())).thenReturn(false);
        when(wishListRepository.wishListSizeByUserId(anyString())).thenReturn(25L);

        assertThrows(WishListFullException.class, () -> createWishProductUseCase.saveWishProduct(wishProduct), "Sua lista de desejo está cheia");
    }


}
