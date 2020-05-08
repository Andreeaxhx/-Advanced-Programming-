package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Player;

@Repository("fakeDao")
public class FakePlayerDataAccessService implements PlayerDao{

	
	private static List<Player> DB = new ArrayList<>();
	
	@Override
	public int insertPlayer(UUID id, Player player) {
		
		DB.add(new Player(id, player.getName()));
		return 1;
		
	}

	@Override
	public List<Player> selectAllPeople(){
		return DB;
	}

	@Override
	public Optional<Player> selectPlayerByID(UUID id) {
		return DB.stream()
				.filter(player -> player.getId().equals(id))
				.findFirst();
	}

	@Override
	public int deletePlayerByID(UUID id) {
		Optional<Player> playerMaybe = selectPlayerByID(id);
		if (playerMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(playerMaybe.get());
		return 1;
	}

	@Override
	public int updatePlayerByID(UUID id, Player update) {
		return selectPlayerByID(id)
				.map(player->{
					int indexOfPlayerToUpdate = DB.indexOf(player);
					if(indexOfPlayerToUpdate>=0) {
						DB.set(indexOfPlayerToUpdate, new Player(id, update.getName()));
						return 1;
						
					}
					return 0;
				})
				.orElse(0);
	}
	
	
}
