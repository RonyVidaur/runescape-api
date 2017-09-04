package me.ronyvidaur.runescape.service;

import me.ronyvidaur.runescape.entity.Player;
import me.ronyvidaur.runescape.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers(long scoreboardId) {
        List<Player> players = new ArrayList<>();
        playerRepository.findByScoreboardId(scoreboardId)
                .forEach(players::add);
        return players;
    }


    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    public void removePlayer(long id) {
        playerRepository.delete(id);
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }
}
