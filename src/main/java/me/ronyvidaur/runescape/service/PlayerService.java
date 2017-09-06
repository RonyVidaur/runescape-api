package me.ronyvidaur.runescape.service;

import me.ronyvidaur.runescape.entity.Player;
import me.ronyvidaur.runescape.exception.NotFoundException;
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
                .stream()
                .sorted((p1,p2) -> Integer.compare(p2.getXp(), p1.getXp()))
                .limit(10)
                .forEach(players::add);
        return players;
    }


    public Player addPlayer(Player player) {
        logger.info("Saving player in database: [" + player + "]");
        return playerRepository.save(player);
    }

    public boolean removePlayer(long id) throws NotFoundException {
        if (playerRepository.exists(id)) {
            playerRepository.delete(id);
            logger.info("Succesfully deleted player with Id: " + id);
            return true;
        } else {
            logger.error("Failed to delete player with Id: " + id + " it does not exist");
            return false;
        }
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
        logger.info("successfuly updated player" + player);
    }

    public Player getPlayer(long id) {
        logger.info("looking for player with ID: " + id);
        return playerRepository.findOne(id);
    }
}
