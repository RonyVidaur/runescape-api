package me.ronyvidaur.runescape.entity;


import javax.persistence.*;

@Entity
@Table(name = "Players")
public class Player {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @ManyToOne(targetEntity = Scoreboard.class)
    @JoinColumn(name="scoreboard_id", nullable=false)
    private Scoreboard scoreboard;
    private String name;
    private int playerLevel;
    private int xp;

    public Player() {}

    public Player(String name, int playerLevel, Long scoreboardId, int xp) {
        this.name = name;
        this.playerLevel = playerLevel;
        this.scoreboard = scoreboard;
        this.xp = xp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return playerLevel;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }
}
