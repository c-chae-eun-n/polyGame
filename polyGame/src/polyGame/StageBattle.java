package polyGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monsterList = null;
	Random random = new Random();
	int monDead = 0;
	int playerDead = 0;

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		while (run) {
			if (turn) {
				printCharacter();
				if (p_index < playerList.size()) {
					playerAttack(p_index);

					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}

			} else if (!turn) {
				if (m_index < monsterList.size()) {
					monsterAttack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}
			checkLive();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void monsterRandomSet() {
		unitManager.monsterList.clear();
		unitManager.monsterRandomSet(4);
		
		playerList = null;
		playerList = unitManager.playerList;
		
		monsterList = null;
		monsterList = unitManager.monsterList;
		
		monDead = monsterList.size();
		playerDead = playerList.size();
	}

	public void printCharacter() {
		System.out.println("======= [BATTLE] =======");
		
		System.out.println("======= [PLAYER] =======");
		for(int i=0; i<playerList.size(); i++)
			playerList.get(i).printStatus();
		
		System.out.println("======= [MONSTER =======");
		for(int i=0; i<monsterList.size(); i++) {
			monsterList.get(i).printStatus();
		}
	}
	
	public void playerAttack(int index) {
		Player p = playerList.get(index);
		if(p.getCurHp() <= 0)
			return;
		
		System.out.println("======= [메뉴 선택] =======");
		System.out.println(" [" + p.getName() + "] [1.어택] [2.스킬]");
		int sel = GameManager.inputNumber("");
		if(sel == 1) {
			while(true) {
				int idx = random.nextInt(monsterList.size());
				
				if(monsterList.get(idx).getCurHp() > 0) {
					p.attack(monsterList.get(idx));
					break;
				} else if (sel == 2) {
				}
			}
		}
	}
	
	public void monsterAttack(int index) {
		Unit m = monsterList.get(index);
		if(m.getCurHp() <= 0)
			return;
		while(true) {
			int idx = random.nextInt(playerList.size());
			if(playerList.get(idx).getCurHp() > 0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
	}
	
	private void checkLive() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getCurHp() <= 0) {
				num += 1;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monsterList.size(); i++) {
			if (monsterList.get(i).getCurHp() <= 0) {
				num += 1;
			}
		}
		monDead = monsterList.size() - num;

	}
}
