package me.ronyvidaur.runescape.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Scoreboards")
public class Scoreboard {

    @Id
    @Column(name = "Id", nullable = false)
    private long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "scoreboard", targetEntity = Player.class)
    private List<Player> players = new ArrayList<>();

    public Scoreboard() {}

    public Scoreboard(long id, String name, String description, List<Player> players) {
        this.name = name;
        this.description = description;
        this.players = players;
        this.id = id;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public List<Player> getPlayers() {

        return players.stream().sorted((p1,p2) -> Integer.compare(p2.getXp(), p1.getXp()))
                .collect(Collectors.toList());
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
