package polyGame;

public class Unit {
	private int curHp;
	private int maxHp;
	private int power;
	private String name;
	
	public Unit() {};
	
	public Unit(String name, int maxHp, int power) {
		this.setName(name);
		this.maxHp = maxHp;
		this.curHp = maxHp;
		this.setPower(power);
	}
	
	public int getCurHp() {
		return this.curHp;
	}
	
	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlay(int maxHp, int power) {
		this.maxHp = maxHp;
		this.curHp = maxHp;
		this.power = power;
	}
	
	public void attack(Unit target) {
		target.curHp -= power;
		System.out.println("[" + name + "]이(가) " + "[" + target.name + "]에게 " + power + "의 데미지를 입힙니다.");
		if(target.curHp <= 0) {
			if(target instanceof Player) {
				System.err.println("[" + target.name + "] 사망-");
				target.curHp = 0;
			} else {
				System.err.println("[" + target.name + "]을(를) 처치했습니다.\n");
				target.curHp = 0;
			}
		}
	}
	
	public void printStatus() {
		System.out.println("        [" + name + "] [" + curHp + "/" + maxHp + "] [" + power + "]");
	}
}
