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
	
	public void monsterRandomSet(int size) {
		for(int i=0; i<size; i++) {
			int num = random.nextInt(monsters.length);
			try {
				Class<?> clazz = Class.forName(path + monsters[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;
				int hp = random.nextInt(100) + 100;
				int power = random.nextInt(10) + 10;
				temp.setMonster(hp, power);
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
