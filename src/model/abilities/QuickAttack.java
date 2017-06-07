package model.abilities;

/**
 * Quick Attack ability.
 *
 * @author Connor D. Milligan
 */
public class QuickAttack extends DamageAbility {
    // Default values for Quick Attack
    public static final String QUICK_ATTACK_NAME = "Quick Attack";
    public static final String QUICK_ATTACK_DESCRIPTION = "An accurate yet weak attack.";
    public static final int QUICK_ATTACK_DAMAGE = 30;
    public static final int QUICK_ATTACK_ACCURACY = 90;

    /**
     * Quick Attack Constructor
     */
    public QuickAttack() {
        super(QUICK_ATTACK_NAME, QUICK_ATTACK_DESCRIPTION, QUICK_ATTACK_DAMAGE, QUICK_ATTACK_ACCURACY);
    }
}
