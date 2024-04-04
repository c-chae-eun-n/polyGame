package polyGame;

public class UnitWolf extends Unit {

	public UnitWolf() {
		setName("늑대");
	}
	
	public void skill(Unit target, Unit target2) {
		System.err.println("[늑대] 돌진-! 2연속 공격!!");
		if(target.isShield()) {
			System.err.println("[" + target.getName() + "]" + " 쉴드 발동 공격 실패!!");
		}else {
			target.setCurHp(target.getCurHp()-(super.getPower()));
			System.err.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]에게 " + super.getPower() + "의 데미지를 입힙니다.");
		}
		if(target2.isShield()) {
			System.err.println("[" + target2.getName() + "]" + " 쉴드 발동 공격 실패!!");
		}else {
			target2.setCurHp(target2.getCurHp()-(super.getPower()));
			System.err.println("[" + super.getName() + "]가 " + "[" + target2.getName() + "]에게 " + super.getPower() + "의 데미지를 입힙니다.");
		}
		
		if(target.getCurHp() <= 0) {
			System.err.println("[" + target.getName() + "] 사망-");
			target.setCurHp(0);
		} else if(target2.getCurHp() <= 0) {
			System.err.println("[" + target2.getName() + "] 사망-");
			target2.setCurHp(0);
		} 
	}
}
