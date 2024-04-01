package polyGame;

public class Unit {
	private int curHp;
	private int maxHp;
	private int power;
	private String name;
	
	public Unit() {};
	
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.curHp = maxHp;
		this.power = power;
	}
}
