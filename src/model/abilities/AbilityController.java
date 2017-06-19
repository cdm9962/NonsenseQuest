//package model.abilities;
//
//import model.Player;
//import model.items.Weapon;
//
//import java.util.Random;
//
///**
// * Controller class to handle all ability effects on the player object.
// */
//public class AbilityController {
//    // Private state of the ability controller
//    private Player player;
//    private Random rand;
//
//    /**
//     * AbilityController Constructor.
//     * @param player the player activating the ability
//     */
//    public AbilityController(Player player) {
//        this.player = player;
//        rand = new Random();
//    }
//
//    /**
//     * Method to resolve an ability.
//     * @param ability the ability to resolve
//     * @return int representing the modifier of the ability
//     */
//    public int resolveAbility(Ability ability) {
//        // Accuracy check
//        int hits = rand.nextInt(100) + 1;
//
//        // Checks for damage ability
//        if(ability instanceof DamageAbility) {
//            DamageAbility damageAbility = (DamageAbility) ability;
//            if (damageAbility.getAccuracy() > hits) {
//                return calculateDamage(damageAbility);
//            }
//        }
//
//        // Ability fails
//        System.out.println(player.getName() + " Misses!");
//        return 0;
//    }
//
//    /**
//     * Method to calculate character damage value.
//     * @return int representing the character damage value
//     */
//    public int calculateDamage(DamageAbility ability) {
//        // Adds characters power to the damage value
//        int result = player.getPower();
//
//        //Adds left weapon to damage value
//        if (player.getActiveItemLeft() instanceof Weapon) {
//            result  += ((Weapon) player.getActiveItemLeft()).getDamage();
//        }
//        // Adds right weapon to damage value
//        if(player.getActiveItemRight() instanceof Weapon) {
//            result += ((Weapon) player.getActiveItemRight()).getDamage();
//        }
//
//        // Adds ability power to damage value
//        result += ability.getDamage();
//
//        // Returns the total damage of the ability
//        System.out.println(player.getName() + " Hits for " + result + " damage!");
//        return result;
//    }
//}
