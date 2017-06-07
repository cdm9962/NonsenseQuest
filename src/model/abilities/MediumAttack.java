package model.abilities;

/**
 * Medium Attack ability.
 *
 * @author Connor D. Milligan
 */
public class MediumAttack extends DamageAbility {
    // Default values for Medium Attack
    public static final String MEDIUM_ATTACK_NAME = "Medium Attack";
    public static final String MEDIUM_ATTACK_DESCRIPTION = "A basic attack.";
    public static final int MEDIUM_ATTACK_DAMAGE = 40;
    public static final int MEDIUM_ATTACK_ACCURACY = 80;

    /**
     * Medium Attack Constructor
     */
    public MediumAttack() {
        super(MEDIUM_ATTACK_NAME, MEDIUM_ATTACK_DESCRIPTION, MEDIUM_ATTACK_DAMAGE, MEDIUM_ATTACK_ACCURACY);
    }
}