package me.ronyvidaur.runescape.service;

import me.ronyvidaur.runescape.entity.Scoreboard;
import me.ronyvidaur.runescape.repository.ScoreboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    public List<Scoreboard> getAllScoreboards() {
        List<Scoreboard> scoreboards = new ArrayList<>();
        scoreboardRepository.findAll()
                .forEach(scoreboards::add);
        return scoreboards;
    }

    public Scoreboard getScoreboard(long id) {
        return scoreboardRepository.findOne(id);
    }
}
