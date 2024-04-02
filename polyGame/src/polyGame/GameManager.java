package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	Random random = new Random();
	static Scanner scan = new Scanner(System.in);
	
	static String nextStage = "";
	String curStage = "";
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageTitle());
		stageList.put("LOBBY", new StageTitle());
		
		nextStage = "TITLE";
	}
	
	public boolean changeStage() {
		return true;
	}
}
