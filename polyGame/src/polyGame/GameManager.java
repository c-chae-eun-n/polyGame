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
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		
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
	
	public static int inputNumber(String message) {
		int number = 0;
		
		try {
			System.out.println(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력하세요.");
		}
		
		return number;
	}
	
	public static String inputString(String message) {
		System.out.println(message + " : ");
		return scan.next();
	}
}
