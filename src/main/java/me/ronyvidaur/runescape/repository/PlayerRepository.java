package me.ronyvidaur.runescape.repository;

import me.ronyvidaur.runescape.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

     List<Player> findByScoreboardId(long scoreboardId);
}
