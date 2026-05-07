package com.epictask.controller;

import com.epictask.model.PlayerModel;
import com.epictask.repository.PlayerRepository;
import com.epictask.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    @GetMapping("/profile")
    public PlayerModel getPlayer(){
        return playerRepository.findById(5L).orElse(null);
    }

    @PostMapping
    public PlayerModel addPlayer(@RequestBody PlayerModel playerModel){
        return playerRepository.save(playerModel);
    }

    @DeleteMapping("/profile/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerRepository.deleteById(id);
    }

    @PostMapping("/profile/{id}/check")
    public ResponseEntity<String> updatePlayer(@PathVariable Long id){
        playerService.habitDone(id);
        return ResponseEntity.ok("Check-in realizado com sucesso!");
    }
}
