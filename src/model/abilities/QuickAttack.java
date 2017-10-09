package model.abilities;

import model.Player;

/**
 * Quick Attack ability.
 *
 * @author Connor D. Milligan
 */
public class QuickAttack extends Ability {
    // Default values for Quick Attack
    public static final String QUICK_ATTACK_NAME = "Quick Attack";
    public static final String QUICK_ATTACK_DESCRIPTION = "An accurate yet weak attack.";
    public static final int QUICK_ATTACK_DAMAGE = 30;
    public static final int QUICK_ATTACK_ACCURACY = 90;

    /**
     * Quick Attack Constructor
     */
    public QuickAttack(Player player, Player enemy) {
        super(QUICK_ATTACK_NAME, QUICK_ATTACK_DESCRIPTION, player, enemy);
    }

    @Override
    public void resolveAbility() {
        System.out.println(this.getName());
    }

    @Override
    public boolean isHit() {
        return false;
    }
}
