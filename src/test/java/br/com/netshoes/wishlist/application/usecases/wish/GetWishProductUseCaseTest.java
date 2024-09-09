package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.NotFoundException;
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
class GetWishProductUseCaseTest {
    @InjectMocks
    GetWishProductUseCase getWishProductUseCase;

    @Mock
    WishListRepositoryGateway wishListRepository;

    @Test
    void Should_ReturnWishProduct_When_FindWishProduct(){
        WishProduct wishProduct = new WishProduct("123", "userID", 2);
        when(wishListRepository.getWishProductByUserIdAndProductId(anyString(),anyString())).thenReturn(wishProduct);

        WishProduct wishProductResult = getWishProductUseCase.getWishProductByUserIdAndProductId("123", "userID");
        assertEquals(wishProduct, wishProductResult);
    }

    @Test
    void Should_ThrowException_When_DoesNotFindWishProduct(){
        when(wishListRepository.getWishProductByUserIdAndProductId(anyString(),anyString())).thenReturn(null);
        assertThrows(NotFoundException.class, () -> getWishProductUseCase.getWishProductByUserIdAndProductId("150", "userID"),
                "Produto não se encontra na lista de desejos");
    }
}
