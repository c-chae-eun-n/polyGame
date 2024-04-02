package polyGame;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		int sel = 0;
		while(sel != 1 && sel != 2) {
			System.out.println("======= [LOBBY] =======");
			System.out.print("   [1.전투]   [2.종료]");
			sel = GameManager.inputNumber("");
			if(sel == 1) {
				GameManager.nextStage = "BATTLE";
			} else if(sel == 2) {
				GameManager.nextStage = "";
			} else {
				System.err.println("1 또는 2만 입력해주세요.");
			}
		}
		
		return false;
	}

	@Override
	public void monsterRandomSet() {
		// TODO Auto-generated method stub
		
	}

}
