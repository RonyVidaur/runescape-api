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
        logger.info("getting all players in the scoreboard with ID: %s", scoreboardId);
        List<Player> players = new ArrayList<>();
        playerRepository.findByScoreboardId(scoreboardId)
                .stream()
                .sorted((p1,p2) -> Integer.compare(p2.getXp(), p1.getXp()))
                .limit(10)
                .forEach(players::add);
        return players;
    }


    public Player addPlayer(Player player) {
        logger.info("Saving player in database: [%s]", player);
        return playerRepository.save(player);
    }

    public boolean removePlayer(long id)  {
        if (playerRepository.exists(id)) {
            playerRepository.delete(id);
            logger.info("Successfully deleted player with Id: %s", id);
            return true;
        } else {
            logger.error("Failed to delete player with Id: %s +  it does not exist", id);
            return false;
        }
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
        logger.info("successfully updated player %s", player);
    }

    public Player getPlayer(long id) {
        return playerRepository.findOne(id);
    }
}
