/*
package me.ronyvidaur.runescape.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private long Id;

    private String name;
    private String description;

    @ManyToMany
    private List<Player> players = new ArrayList<>();

    public Category() {}

    public Category(String name, String description, List<Player> players) {
        this.name = name;
        this.description = description;
        this.players = players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
*/
