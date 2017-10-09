package model.abilities;

import model.Player;

/**
 * Heavy Attack ability.
 *
 * @author Connor D. Milligan
 */
public class HeavyAttack extends Ability {
    // Default values for Heavy Attack
    public static final String HEAVY_ATTACK_NAME = "Heavy Attack";
    public static final String HEAVY_ATTACK_DESCRIPTION = "A well calculated strike.";
    public static final int HEAVY_ATTACK_MIN_DAMAGE = 40;
    public static final int HEAVY_ATTACK_MAX_DAMAGE = 60;
    public static final double HEAVY_ATTACK_ACCURACY = 0.70;

    /**
     * Heavy Attack Constructor
     * @param player the player character
     * @param enemy the enemy character
     */
    public HeavyAttack(Player player, Player enemy) {
        super(HEAVY_ATTACK_NAME, HEAVY_ATTACK_DESCRIPTION, player, enemy);
    }

    @Override
    public boolean isHit() {
        double result = rand.nextDouble();
        // Hit success
        if(result <= HEAVY_ATTACK_ACCURACY) {
            return true;
        }
        // Hit failure
        return false;
    }
}
