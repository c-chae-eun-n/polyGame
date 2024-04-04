package polyGame;

public class Warrior extends Player {

	public Warrior(int max, int power) {
		super("전사", max, power);
	}

	@Override
	public void skill(Unit target) {
		System.err.println("[전사] 쉴드 발동!!");
		setShield(true);
		target.setCurHp(target.getCurHp()-(getPower()/2));
		System.err.println("[" + target.getName() + "]가 " + "[" + getName() + "]의 쉴드 효과에 " + getPower()/2 + "의 데미지를 입었다.");
		if(target.getCurHp() <= 0) {
			System.err.println("[" + target.getName() + "]을(를) 처치했습니다.");
			target.setCurHp(0);
		}
	}
}
