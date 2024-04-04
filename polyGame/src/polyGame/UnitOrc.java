package polyGame;

public class UnitOrc extends Unit {

	public UnitOrc() {
		setName("오크");
	}
	
	public void skill(Unit target) {
		System.err.println("[오크] 격노-! 3배 공격력으로 강타!!");
		if(isStun()) {
			System.err.println("스턴이 걸려서 공격 실패!!");
			setStun(false);
			return;
		}
		if(target.isShield()) {
			System.err.println("[" + target.getName() + "]" + " 쉴드 발동 공격 실패!!");
			target.setShield(false);
			return;
		}
		target.setCurHp(target.getCurHp()-(super.getPower()*3));
		System.err.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]에게 " + super.getPower()*3 + "의 데미지를 입힙니다.");
		if(target.getCurHp() <= 0) {
			System.err.println("[" + target.getName() + "] 사망-");
			target.setCurHp(0);
		}
	}
}
