public class TownhealerVendor implements ShopInterface{

    @Override
    public void visit(PlayerCharacter player) {
        System.out.println("Du betrittst das Ärztehaus. Du kannst dich für 20 Gold heilen lassen.");
        System.out.println("(1) für Heilung (Kosten: 20 Gold)");
        System.out.println("(2) du möchtest keine Heilung und verlässt das Ärztehaus wieder.");


        int input = GameUtility.readInt("-> ", 2);
        if(input == 1){

            if (player.getCurrentHP() >= player.getMaxHP()){
                System.out.println("Du bist nicht verwundet. Der Heiler schickt dich fort.");
                GameUtility.printSeperator(30);
                // go back to marketplace
                return;
            }

            if (player.getCharacterInventory().checkAffordable(20)){
                player.getCharacterInventory().payGold(20);
                // get difference between max possible hp and current hp
                int damageAmount = player.getMaxHP() - player.getCurrentHP();
                player.heal(damageAmount);
                System.out.println("Der Heiler hat " + damageAmount + " HP wiederhergestellt! Du gehst erholt wieder auf den Marktplatz");
                GameUtility.printSeperator(30);
                return;
            }
            System.out.println("Du kannst dir dies nicht leisten! Der Heiler schickt dich fort.");
            GameUtility.printSeperator(30);
            return;

        } else if (input == 2){
            GameUtility.printSeperator(30);
            return;
        }
    }
}
