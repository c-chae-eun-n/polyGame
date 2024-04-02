package polyGame;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		String start = "";
		System.out.println("======= TEXT RPG =======");
		while(!start.equals("시작")) {
			start = GameManager.inputString("    [시작]을 입력하세요.");
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void monsterRandomSet() {
		
	}
	
}
