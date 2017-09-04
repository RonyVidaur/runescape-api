package me.ronyvidaur.runescape.controller;


import me.ronyvidaur.runescape.entity.Scoreboard;
import me.ronyvidaur.runescape.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

    @RequestMapping(method = RequestMethod.GET, value = ("/scoreboards"))
    public List<Scoreboard> getAllScoreboards() {
        return scoreboardService.getAllScoreboards();
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/scoreboards/{id}"))
    public Scoreboard getScoreboardById(@PathVariable long id) {
        return scoreboardService.getScoreboardById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/scoreboards"))
    public String addScoreboard(@RequestBody Scoreboard scoreboard) {
        scoreboardService.addScoreboard(scoreboard);
        return "Success";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/scoreboards/{id}"))
    public void removeScoreboard(@PathVariable long id) {
        scoreboardService.removeScoreboard(id);
    }

    @RequestMapping(method = RequestMethod.PUT,  value = ("/scoreboards/{id}"))
    public void updateScoreboard(@RequestBody Scoreboard scoreboard, @PathVariable long id) {
        scoreboardService.updateScoreboard(scoreboard);
    }
}
