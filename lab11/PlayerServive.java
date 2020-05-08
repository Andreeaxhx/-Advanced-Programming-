package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PlayerDao;
import com.example.demo.model.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PlayerServive {
	
	private PlayerDao playerDao;

	@Autowired
	public PlayerServive(@Qualifier("fakeDao") PlayerDao playerDao) {
		this.playerDao=playerDao;
	}
	public int addPlayer(Player player)
	{
		return playerDao.insertPlayer(player);
	}
	public List<Player> getAllPeople(){
		return playerDao.selectAllPeople();
	}
	
	public Optional<Player> getPlayerByID(UUID id){
		return playerDao.selectPlayerByID(id);
	}
	
	public int deletePlayer(UUID id) {
		return playerDao.deletePlayerByID(id);
	}
	
	public int updatePlayer(UUID id, Player newPlayer) {
		return playerDao.updatePlayerByID(id, newPlayer);
		
	}
}
	
