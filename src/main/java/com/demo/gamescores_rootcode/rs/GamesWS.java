package com.demo.gamescores_rootcode.rs;

import com.demo.gamescores_rootcode.model.Game;
import com.demo.gamescores_rootcode.payload.ErrorResponse;
import com.demo.gamescores_rootcode.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/games")
public class GamesWS {
    @Autowired
    GameService gameService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> saveGame(@RequestBody Game game) {
        try {
            Game createdGame = gameService.createGameRecord(game);
            return ResponseEntity.ok(createdGame);
        } catch (IllegalArgumentException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> getAllGames() {
        try {
            return ResponseEntity.ok(gameService.getAllGames());
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }
}
