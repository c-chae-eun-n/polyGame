package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private Vector<Player> playerList;
	private Vector<Unit> monsterList = new Vector<>();
	
	private String path = "polyGame.";
	private String monsters[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	private String players[] = {"Warrior", "Wizard", "Healer"};
	private Random random = new Random();

	private UnitManager() {
		playerList = new Vector<>();
	}
	
	private static UnitManager instance = new UnitManager();
	
	public static UnitManager getInstance() {
		return instance;
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
				temp.setPlay(hp, power);
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void playerRandomSet(String players) {
		try {
			int hp = random.nextInt(501) + 500;
			int power = random.nextInt(51) + 40;
			Class<?> clazz = Class.forName(path + players);
			Class<?>[] params = new Class<?>[] {int.class, int.class};
			Object obj = clazz.getDeclaredConstructor(params).newInstance(hp, power);
			Player temp = (Player) obj;
			playerList.add(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String selectPlayer() {
		String player = "";
		int index = -1;
		for(int i=0; i<players.length; i++) {
			System.out.println((i+1) + ") " + players[i]);
		}
		while(true) {
			index = GameManager.inputNumber("원하는 플레이어 번호 입력 : ")-1;
			if(index >= 0 && index < players.length)
				break;
			else
				System.err.printf("%d~%d만 입력 가능합니다.", 1, players.length);
		}
		
		player = players[index];
		
		return player;
	}
	
	public void clearMonsterList() {
		monsterList.clear();
	}
	
	public int playerListSize() {
		return playerList.size();
	}
	
	public Vector<Player> getPlayerList(){
		return playerList;
	}
	
	public Vector<Unit> getMonsterList(){
		return monsterList;
	}
}
