package com.example.spring_music.app.base.initData;

import com.example.spring_music.app.cart.service.CartService;
import com.example.spring_music.app.member.service.MemberService;
import com.example.spring_music.app.order.service.OrderService;
import com.example.spring_music.app.product.service.ProductService;
import com.example.spring_music.app.song.service.SongService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestInitData implements InitDataBefore {
    @Bean
    CommandLineRunner initData(
            MemberService memberService,
            SongService songService,
            ProductService productService,
            CartService cartService,
            OrderService orderService) {
        return args -> {
            before(memberService, songService, productService, cartService, orderService);
        };
    }
}
