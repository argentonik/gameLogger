package gamers;

import enums.Action;

public class Computer extends Gamer {

    public Computer(String name) { super(name); }

    @Override
    protected int generateAction() {
        // if health < 35%, then chance to heal = 60%
        if (health < FULL_HEALTH / 100 * 35) {
            if (Math.random() < 0.6) {
                return Action.HEAL.ordinal();
            } else {
                return generateRandomNumber(0, Action.CRITICAL_DAMAGE.ordinal());
            }
        } else {
            return super.generateAction();
        }
    }
}