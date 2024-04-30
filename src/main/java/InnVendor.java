public class InnVendor implements ShopInterface {

    @Override
    public void visit(PlayerCharacter player) {
        System.out.println("Du betrittst das Gasthaus und kannst dich als ausruhen.");
        System.out.println("Gasthäuser heilen nur geringfügig HP," +
                " wobei sie die MP vollständig regenerieren!");
        System.out.println("Du kannst für 5 Gold eine Nacht im Gasthaus schlafen.");
        System.out.println("(1) für die Übernachtung (Kosten: 5 Gold)");
        System.out.println("(2) du möchtest nicht verweilen und verlässt das Gasthaus.");

        int input = GameUtility.readInt("->", 2);
        if(input == 1){

            if (player.getCharacterInventory().checkAffordable(5)){
                player.getCharacterInventory().payGold(5);
                System.out.println("Du nächtigst im Gasthaus und wachst voller Energie wieder auf!");
                player.restoreWithInn();
            }
        } else if (input == 2){
            GameUtility.printSeperator(30);
            return;
        }
    }
}
