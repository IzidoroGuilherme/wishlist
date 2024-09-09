package br.com.netshoes.wishlist.application.usecases.wish;

import br.com.netshoes.wishlist.application.gateways.WishListRepositoryGateway;
import br.com.netshoes.wishlist.domain.entities.wish.WishProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserWishListUseCaseTest {
    @InjectMocks
    GetUserWishListUseCase getUserWishListUseCase;

    @Mock
    WishListRepositoryGateway wishListRepositoryGateway;

    @Test
    void Should_ReturnUserWishList_When_HasData(){
        List<WishProduct> wishList = List.of(new WishProduct("123", "userID", 1),
                new WishProduct("124", "userID", 1),
                new WishProduct("125", "userID", 10));
        when(wishListRepositoryGateway.getWishListByUserId(anyString())).thenReturn(wishList);

        List<WishProduct> wishListResult = getUserWishListUseCase.getUserWishlist("UserID");
        assertEquals(wishList.size(), wishListResult.size());
        assertArrayEquals(wishList.toArray(), wishListResult.toArray());
    }

    @Test
    void Should_ReturnEmptyList_When_UserDoesNotHaveWishList(){
        List<WishProduct> wishList = new ArrayList<>();
        when(wishListRepositoryGateway.getWishListByUserId(anyString())).thenReturn(wishList);

        List<WishProduct> wishListResult = getUserWishListUseCase.getUserWishlist("UserID");
        assertEquals(0, wishListResult.size());
    }
}
