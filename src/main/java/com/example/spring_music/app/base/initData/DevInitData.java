package com.example.spring_music.app.base.initData;

import com.example.spring_music.app.member.service.MemberService;
import com.example.spring_music.app.product.service.ProductService;
import com.example.spring_music.app.song.service.SongService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevInitData implements InitDataBefore {
    @Bean
    CommandLineRunner initData(MemberService memberService, SongService songService, ProductService productService) {
        return args -> {
            before(memberService, songService, productService);
        };
    }
}
