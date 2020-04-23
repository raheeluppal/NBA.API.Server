package NBA.API.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abbreviation;
    private String city;
    private String conference;
    private String division;
    private String full_name;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL, mappedBy = "team",targetEntity = Player.class)
    private List<Player> players;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbrevation) {
        this.abbreviation = abbrevation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conferance) {
        this.conference = conferance;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", abbrevation='" + abbreviation + '\'' +
                ", city='" + city + '\'' +
                ", conference='" + conference + '\'' +
                ", division='" + division + '\'' +
                ", full_name='" + full_name + '\'' +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
