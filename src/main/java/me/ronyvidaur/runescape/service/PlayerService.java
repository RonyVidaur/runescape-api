package me.ronyvidaur.runescape.service;

import me.ronyvidaur.runescape.entity.Player;
import me.ronyvidaur.runescape.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class PlayerService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers(long scoreboardId) {
        logger.info("getting all players in the scoreboard with ID: " + scoreboardId);
        List<Player> players = new ArrayList<>();
        playerRepository.findByScoreboardId(scoreboardId)
                .forEach(players::add);
        return players;
    }


    public void addPlayer(Player player) {
        logger.info("Saving player in database: [" + player + "]");
        playerRepository.save(player);
    }

    public void removePlayer(long id) {
        playerRepository.delete(id);
        logger.info("Succesfuly removed player with ID: " + id);
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
        logger.info("successfuly updated player" + player);
    }
}
