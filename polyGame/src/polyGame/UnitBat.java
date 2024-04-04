package polyGame;

public class UnitBat extends Unit {

	public UnitBat() {
		setName("박쥐");
	}
	
	public void skill(Unit target) {
		System.err.println("[박쥐] 바람일으키기-! 생명력 흡혈!!");
		if(target.isShield()) {
			System.err.println("[" + target.getName() + "]" + " 쉴드 발동 공격 실패!!");
			return;
		}
		target.setCurHp(target.getCurHp()-(getPower()*2));
		setCurHp(getCurHp()+(getPower()*2));
		System.err.println("[" + getName() + "]가 " + "[" + target.getName() + "]에게 " + getPower()*2 + "의 생명력을 흡혈합니다.");
		if(target.getCurHp() <= 0) {
			System.err.println("[" + target.getName() + "] 사망-");
			target.setCurHp(0);
		}
	}
}
