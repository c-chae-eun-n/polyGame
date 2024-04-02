package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monsterList = new Vector<>();
	
	String path = "polyGame.";
	String monsters[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	Random random = new Random();

	public UnitManager() {
		playerList.add(new Player("전사", 1000, 80));
		playerList.add(new Player("마법사", 800, 65));
		playerList.add(new Player("힐러", 500, 45));
	}
	
}
