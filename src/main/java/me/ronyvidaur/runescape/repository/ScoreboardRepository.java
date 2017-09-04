package me.ronyvidaur.runescape.repository;

import me.ronyvidaur.runescape.entity.Scoreboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {

}
