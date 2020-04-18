package NBA.API.controllers;

import NBA.API.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service){
        this.service = service;
    }
}
