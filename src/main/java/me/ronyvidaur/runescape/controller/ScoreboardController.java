package me.ronyvidaur.runescape.controller;


import me.ronyvidaur.runescape.entity.Scoreboard;
import me.ronyvidaur.runescape.exception.NotFoundException;
import me.ronyvidaur.runescape.service.ScoreboardService;
import me.ronyvidaur.runescape.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

    @RequestMapping(method = RequestMethod.GET, value = ("/scoreboards"))
    public ResponseEntity getAllScoreboards() {
       return ResponseEntity.ok().body(ResponseBuilder.build(scoreboardService.getAllScoreboards(),"success","GET","/scoreboards"));
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/scoreboards/{id}"))
    public ResponseEntity getScoreboard(@PathVariable long id) throws NotFoundException {
        if(scoreboardService.getScoreboard(id) != null){
            return ResponseEntity.ok().body(ResponseBuilder.build(scoreboardService.getScoreboard(id),"success","get", "scoreboards/" + id));
        } else {
            throw new NotFoundException(id);
        }
    }


}
