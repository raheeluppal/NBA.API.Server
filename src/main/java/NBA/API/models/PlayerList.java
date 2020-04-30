package NBA.API.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlayerList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long teamId;

    @OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL, mappedBy = "playerList",targetEntity = Player.class)
    private List<Player> data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    public Team getTeamById(Long teamId){
        Team result = null;
        for(Player p : data){
           result = p.getTeam();
        }
        return result;
    }
}
