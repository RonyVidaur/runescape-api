package me.ronyvidaur.runescape.controller;

import me.ronyvidaur.runescape.entity.Player;
import me.ronyvidaur.runescape.exception.NotFoundException;
import me.ronyvidaur.runescape.service.PlayerService;
import me.ronyvidaur.runescape.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/scoreboards/{scoreboardId}")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET, value = ("/players"))
    public ResponseEntity getAllPlayers(@PathVariable long scoreboardId) {
        return ResponseEntity.ok(ResponseBuilder.build(playerService.getAllPlayers(scoreboardId),"success", "GET",  "scoreboards/" + scoreboardId + "/players"));

    }

    @RequestMapping(method = RequestMethod.GET, value = ("/players/{id}"))
    public Player getPlayer(@PathVariable long id) throws Exception {
        if (playerService.getPlayer(id) != null) {
            return playerService.getPlayer(id);
        } else {
            throw new NotFoundException(id);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/players"))
    public ResponseEntity addPlayer(@RequestBody Player player, @PathVariable long scoreboardId) throws SQLException {
        Player newPlayer = new Player(player.getName(), player.getLevel(), scoreboardId, player.getXp());
        Player other;
        other = playerService.addPlayer(newPlayer);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseBuilder.build(newPlayer,"success","POST", "scoreboards/" + scoreboardId + "/players"));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/players/{id}"))
    public ResponseEntity removePlayer(@PathVariable long id) throws NotFoundException {
        Player deletedPlayer = playerService.getPlayer(id);
        if(playerService.removePlayer(id)) {
            return ResponseEntity.ok(ResponseBuilder.build(deletedPlayer, "success", "DELETE", "/players/" + id));
         } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseBuilder.build("","error","DELETE", "/players/" + id));
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = ("/players"))
    public ResponseEntity updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBuilder.build(player, "succes", "PUT", "/players"));
    }
}
