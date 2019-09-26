package gamers;

import enums.Action;
import enums.Color;

public class Gamer {
    protected final int FULL_HEALTH = 100;
    protected int health = FULL_HEALTH;
    private String name;

    public Gamer(String name) { this.name = name; }

    public int getHealth() { return health; }
    public String getName() { return name; }

    public boolean isAlive() { return health > 0; }

    public void makeMove(Gamer enemy) {
        int currentAction = generateAction();
        if (currentAction == Action.NORMAL_DAMAGE.ordinal()) {
            makeNormalDamage(enemy);
        } else if (currentAction == Action.CRITICAL_DAMAGE.ordinal()) {
            makeCriticalDamage(enemy);
        } else if (currentAction == Action.HEAL.ordinal()){
            healYourself();
        }
    }

    private void makeNormalDamage(Gamer enemy) {
        int damage = generateRandomNumber(18, 25);
        enemy.takeDamage(damage);
        printDamage(enemy, damage);
    }

    private void makeCriticalDamage(Gamer enemy) {
        int damage = generateRandomNumber(10, 35);
        enemy.takeDamage(damage);
        printDamage(enemy, damage);
    }

    private void healYourself() {
        int heal = generateRandomNumber(18, 25);
        health += heal;
        // if after heal health much, then max value - health equals to max value
        if (health > FULL_HEALTH) {
            health = FULL_HEALTH;
        }
        printHeal(heal);
    }

    protected int generateAction() {
        // if health is full gamer can't heal
        if (health == FULL_HEALTH) {
            return generateRandomNumber(0, Action.CRITICAL_DAMAGE.ordinal());
        }
        return generateRandomNumber(0, Action.values().length - 1);
    }

    protected int generateRandomNumber(int startRange, int endRange) {
        return (int) (startRange + Math.random() * (endRange - startRange + 1));
    }

    private void printDamage(Gamer enemy, int damage) {
        System.out.println(Color.RED + name + " deals " + damage + " damage to " + enemy.getName() + "." + Color.RED);
        if (!enemy.isAlive()) {
            System.out.println(Color.RESET + enemy.getName() + " died.");
        }
    }

    private void printHeal(int heal) {
        System.out.println(Color.GREEN + name + " heal " + heal + " units of health." + Color.GREEN);
    }

    private void takeDamage(int damage) { health -= damage; }
}
