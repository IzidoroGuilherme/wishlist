package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import br.com.netshoes.wishlist.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteWishProductUseCaseTest {
    @InjectMocks
    DeleteWishProductUseCase deleteWishProductUseCase;

    @Mock
    WishListRepositoryGateway wishListRepository;

    @Mock
    GetWishProductUseCase getWishProductUseCase;

    @Test
    void Should_CallDeleteWishProduct_When_FindWishProduct(){
        WishProduct wishProduct = new WishProduct("123", "userID", 2);
        wishProduct.setWishProductId("123");
        when(getWishProductUseCase.getWishProductByUserIdAndProductId(anyString(),anyString())).thenReturn(wishProduct);

        deleteWishProductUseCase.deleteWishProduct("123","userID");
        verify(wishListRepository, times(1)).deleteWishProduct(wishProduct);
    }

    @Test
    void Should_NotCallCallDeleteWishProductAndThrowError_When_DoesNotFindWishProduct(){
        WishProduct wishProduct = new WishProduct("123", "userID", 2);
        wishProduct.setWishProductId("123");
        when(getWishProductUseCase.getWishProductByUserIdAndProductId(anyString(),anyString())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> deleteWishProductUseCase.deleteWishProduct("123","userID"),
                "Produto não se encontra na lista de desejos");
        verify(wishListRepository, never()).deleteWishProduct(wishProduct);
    }
}
