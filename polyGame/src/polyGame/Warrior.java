package polyGame;

public class Warrior extends Player {

	public Warrior(int max, int power) {
		super("전사", max, power);
	}

	@Override
	public void skill(Unit target) {
		System.err.println("[전사] 공격력 2배!!");
		target.setCurHp(target.getCurHp()-(getPower()*2));
		System.err.println("[" + getName() + "]가 " + "[" + target.getName() + "]에게 " + getPower()*2 + "의 데미지를 입힙니다.");
		if(target.getCurHp() <= 0) {
			System.err.println("[" + target.getName() + "]을(를) 처치했습니다.\n");
			target.setCurHp(0);
		}
	}

}
