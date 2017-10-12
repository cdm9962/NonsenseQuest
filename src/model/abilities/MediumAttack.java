package model.abilities;

import model.Player;

/**
 * Medium Attack ability.
 *
 * @author Connor D. Milligan
 */
public class MediumAttack extends Ability {
    // Default values for Medium Attack
    public static final String MEDIUM_ATTACK_NAME = "Medium Attack";
    public static final String MEDIUM_ATTACK_DESCRIPTION = "A basic attack.";
    public static final int MEDIUM_ATTACK_DAMAGE = 40;
    public static final int MEDIUM_ATTACK_ACCURACY = 80;

    /**
     * Medium Attack Constructor
     */
    public MediumAttack(Player player, Player enemy) {
        super(MEDIUM_ATTACK_NAME, MEDIUM_ATTACK_DESCRIPTION, player, enemy);
    }

    @Override
    public void resolveAbility() {
        System.out.println(this.getName());
    }

    @Override
    public boolean isHit() {
        return false;
    }

    @Override
    public int calculateDamage() {
        return 0;
    }
}