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
        double variance = rand.nextDouble();
        // Hit success
        if(variance <= HEAVY_ATTACK_ACCURACY) {
            return true;
        }
        // Hit failure
        return false;
    }

    @Override
    public int calculateDamage() {
        // calculate random ability variance
        int variance = rand.nextInt(HEAVY_ATTACK_MAX_DAMAGE - HEAVY_ATTACK_MIN_DAMAGE);
        // return damage value
        return HEAVY_ATTACK_MIN_DAMAGE + variance;
    }

    @Override
    public int calculateDamage(int flatBuff, int flatDebuff, double scaleBuff, double scaleDebuff) {
        // calculate random ability variance
        int variance = rand.nextInt(HEAVY_ATTACK_MAX_DAMAGE - HEAVY_ATTACK_MIN_DAMAGE);
        // calculate damage with added buffs and/or debuffs
        int result = (int) ((HEAVY_ATTACK_MIN_DAMAGE + variance + flatBuff + flatDebuff) *
                            ((1 - scaleBuff) + (1 - scaleDebuff)));
        // check that damage does not become negative and return damage value
        if(result >= 0) {
            return result;
        } else {
            return 0;
        }
    }
}
