package polyGame;

public class Wizard extends Player {
	UnitManager unitManager = new UnitManager();

	public Wizard(int max, int power) {
		super("마법사", max, power);
	}

	@Override
	public void skill(Unit target) {
		System.err.println("[마법사] 스턴 발동!!");
		target.setStun(true);
		target.setCurHp(target.getCurHp()-(getPower()/2));
		System.err.println("[" + target.getName() + "]가 " + "[" + getName() + "]의 스턴에 " + getPower()/2 + "의 데미지를 입었다.");
		if(target.getCurHp() <= 0) {
			System.err.println("[" + target.getName() + "]을(를) 처치했습니다.");
			target.setCurHp(0);
		}
	}
}
