package com.example.spring_music.app.song.repositroy;

import com.example.spring_music.app.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByAuthorId(Long id);
}

