package com.example.spring_music.app.cart.entity;

import com.example.spring_music.app.base.entity.BaseEntity;
import com.example.spring_music.app.member.entity.Member;
import com.example.spring_music.app.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CartItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member buyer;
    @ManyToOne(fetch = LAZY)
    private Product product;

    public CartItem(long id) {
        super(id);
    }
}
