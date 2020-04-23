package NBA.API.controllers;

import NBA.API.models.Player;
import NBA.API.models.Team;
import NBA.API.services.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service){
        this.service = service;
    }


    @GetMapping("/players/{id}")
    public ResponseEntity<?> getPlayers(@PathVariable Long id) {
        HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/teams/" + id)
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .header("x-rapidapi-key", "4c4e379b8cmsh5b8ee3f43ccd278p1a858cjsn82edf9884af0")
                .asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Team team = objectMapper
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(response.getBody(), Team.class);
            Long teamId = team.getId();
            List<Player> players = team.getPlayers();



            if (players.size() > 0) {
                return new ResponseEntity<>(players, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (JsonProcessingException ignored) {
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
