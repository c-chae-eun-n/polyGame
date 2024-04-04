package polyGame;

public class Healer extends Player {
	private UnitManager unitManager = UnitManager.getInstance();

	public Healer(int max, int power) {
		super("힐러", max, power);
	}

	@Override
	public void skill(Unit target) {
		System.err.println("[힐러] 모든 플레이어 HP 10% 증가!!");
		for(int i=0; i<unitManager.playerListSize(); i++) {
			Player player = unitManager.getPlayerList().get(i);
			player.setCurHp(player.getCurHp()+ (int)(player.getCurHp()*0.1));
			
			if(player.getCurHp() >= player.getMaxHp()) 
				player.setCurHp(player.getMaxHp());
		}
	}
}
