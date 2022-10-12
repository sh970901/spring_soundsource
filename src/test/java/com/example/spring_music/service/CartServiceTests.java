package com.example.spring_music.service;

import com.example.spring_music.app.cart.entity.CartItem;
import com.example.spring_music.app.cart.service.CartService;
import com.example.spring_music.app.member.entity.Member;
import com.example.spring_music.app.member.repository.MemberRepository;
import com.example.spring_music.app.product.entity.Product;
import com.example.spring_music.app.product.service.ProductService;
import com.example.spring_music.app.song.service.SongService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class CartServiceTests {
    @Autowired
    private SongService songService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartService cartService;

    @Test
    @DisplayName("장바구니에 담기")
    void t1() {
        Member buyer = memberRepository.findByUsername("user1").get();

        Product product1 = productService.findById(1).get();
        Product product2 = productService.findById(2).get();
        Product product3 = productService.findById(3).get();
        Product product4 = productService.findById(4).get();

        CartItem cartItem1 = cartService.addItem(buyer, product1);
        CartItem cartItem2 = cartService.addItem(buyer, product2);
        CartItem cartItem3 = cartService.addItem(buyer, product3);
        CartItem cartItem4 = cartService.addItem(buyer, product4);

        assertThat(cartItem1).isNotNull();
        assertThat(cartItem2).isNotNull();
        assertThat(cartItem3).isNotNull();
        assertThat(cartItem4).isNotNull();
    }

    @Test
    @DisplayName("장바구니에서 제거")
    @Rollback(value = false)
    void t2() {
        Member buyer1 = memberRepository.findByUsername("user1").get();
        Member buyer2 = memberRepository.findByUsername("user2").get();

        Product product1 = productService.findById(1).get();
        Product product2 = productService.findById(2).get();
        Product product3 = productService.findById(3).get();
        Product product4 = productService.findById(4).get();

        cartService.removeItem(buyer1, product1);
        cartService.removeItem(buyer1, product2);
        cartService.removeItem(buyer2, product3);
        cartService.removeItem(buyer2, product4);

        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
    }
}