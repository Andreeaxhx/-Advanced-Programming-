package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerServive;

@RequestMapping("api/v1/player")
@RestController
public class PlayerController {
	
	private final PlayerServive playerService;

	@Autowired
	public PlayerController(PlayerServive playerService) {
		
		this.playerService = playerService;
	}
	
	@PostMapping
	public void addPlayer(@Valid @NotNull @RequestBody Player player) {
		playerService.addPlayer(player);
	}
	
	@GetMapping
	public List<Player> getAllPeople(){
		return playerService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Player getPlayerByID(@PathVariable("id") UUID id) {
		return playerService.getPlayerByID(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePlayerByID(@PathVariable("id") UUID id) {
		playerService.deletePlayer(id);
	}
	
	@PutMapping(path = "{id}")
	public void updatePlayer(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Player playerToUpdate ) {
		playerService.updatePlayer(id, playerToUpdate);
	}
	
	
}
