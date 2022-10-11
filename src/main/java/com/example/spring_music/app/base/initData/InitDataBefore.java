package com.example.spring_music.app.base.initData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

public interface InitDataBefore {
    default void before() {

    }
}
