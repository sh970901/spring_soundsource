package com.example.spring_music.app.song.repositroy;

import com.example.spring_music.app.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
