package me.ronyvidaur.runescape.controller;

import me.ronyvidaur.runescape.entity.Player;
import me.ronyvidaur.runescape.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoreboards/{scoreboardId}")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET, value = ("/players"))
    public List<Player> getAllPlayers(@PathVariable long scoreboardId) {
        return playerService.getAllPlayers(scoreboardId);
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/players"))
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/players/{id}"))
    public void removePlayer(@PathVariable long id) {
        playerService.removePlayer(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = ("/players"))
    public void updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player);
    }
}
