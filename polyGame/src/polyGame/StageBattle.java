package polyGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monsterList = null;
	Random random = new Random();
	int monDead = 0;
	int playerDead = 0;

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public void monsterRandomSet() {
		unitManager.monsterList.clear();
		unitManager.monsterRandomSet(4);
		
		playerList = null;
		playerList = unitManager.playerList;
		
		monsterList = null;
		monsterList = unitManager.monsterList;
		
		monDead = monsterList.size();
		playerDead = playerList.size();
	}

	public void printCharacter() {
		System.out.println("==== [BATTLE] ====");
		
		System.out.println("==== [PLAYER] ====");
		for(int i=0; i<playerList.size(); i++)
			playerList.get(i).printStatus();
		
		System.out.println("==== [MONSTER ====");
		for(int i=0; i<monsterList.size(); i++) {
			monsterList.get(i).printStatus();
		}
	}
	
	
}
