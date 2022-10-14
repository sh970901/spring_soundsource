package com.example.spring_music.app.product.controller;

import com.example.spring_music.app.member.entity.Member;
import com.example.spring_music.app.product.entity.Product;
import com.example.spring_music.app.product.form.ProductForm;
import com.example.spring_music.app.product.service.ProductService;
import com.example.spring_music.app.security.dto.MemberContext;
import com.example.spring_music.app.song.entity.Song;
import com.example.spring_music.app.song.service.SongService;
import com.example.spring_music.util.Ut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {
    private final SongService songService;
    private final ProductService productService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String showCreate(@AuthenticationPrincipal MemberContext memberContext, Model model) {
        Member actor = memberContext.getMember();

        List<Song> songs = songService.findAllByAuthorId(actor.getId());

        model.addAttribute("songs", songs);

        return "product/create";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String create(@AuthenticationPrincipal MemberContext memberContext, @Valid ProductForm productForm) {
        Member author = memberContext.getMember();

        Song song = songService.findById(productForm.getSongId()).get();

        if (author.getId().equals(song.getAuthor().getId()) == false) {
            return "redirect:/product/create?msg=" + Ut.url.encode("%d번 음원에 대한 권한이 없습니다.".formatted(song.getId()));
        }

        Product product = productService.create(song, productForm.getSubject(), productForm.getPrice());
        return "redirect:/product/" + product.getId() + "?msg=" + Ut.url.encode("%d번 상품이 생성되었습니다.".formatted(product.getId()));
    }
}