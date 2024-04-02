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
}
