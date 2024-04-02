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
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
		if(curStage.equals(nextStage))
			return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.monsterRandomSet();
		
		boolean run = true;
		while(true) {
			run = stage.update();
			if(run == false)
				break;
		}
		
		if(nextStage.equals(""))
			return false;
		else
			return true;
	}
}
