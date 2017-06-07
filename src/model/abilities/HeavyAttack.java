package model.abilities;

/**
 * Heavy Attack ability.
 *
 * @author Connor D. Milligan
 */
public class HeavyAttack extends DamageAbility {
    // Default values for Heavy Attack
    public static final String HEAVY_ATTACK_NAME = "Heavy Attack";
    public static final String HEAVY_ATTACK_DESCRIPTION = "A well calculated strike.";
    public static final int HEAVY_ATTACK_DAMAGE = 50;
    public static final int HEAVY_ATTACK_ACCURACY = 70;

    /**
     * Heavy Attack Constructor
     */
    public HeavyAttack() {
        super(HEAVY_ATTACK_NAME, HEAVY_ATTACK_DESCRIPTION, HEAVY_ATTACK_DAMAGE, HEAVY_ATTACK_ACCURACY);
    }
}
