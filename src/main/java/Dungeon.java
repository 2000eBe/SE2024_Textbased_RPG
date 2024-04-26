import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private List<Map> levels;
    private int INITIAL_EXP = 100;
    private int currentLevelIndex;

    public Dungeon(){
        levels = new ArrayList<>();
        initializeLevels();
        currentLevelIndex = 12;

    }

    private void initializeLevels() {
        // Level 1
        List<Monster> monsters1 = new ArrayList<>();
        monsters1.add(new Monster(
                "Kanalisationsratte",
                "Diese übergroßen Ratten sind äußerst aggressiv und versperren den Zugang in den Keller des Turms.",
                25, 20, 5, 8, 10, 1));

        levels.add(new Map(
                "Du hast eine Infiltrationsplan zugesteckt bekommen, der dir den idealen Plan des Turmes zeigt," +
                        " um möglichst wenig Aufmerksamkeit zu erzeugen. \n" +
                        "Der Weg führt dich durch die Kanalisation... \n" +
                        "Kanalisationzugang des dunklen Turms (Level 1)"
                        + "\n" + "Ein schrecklicher Gestank umgibt die Kanalisation.\n" +
                        " Du siehst am Ende des Kanalisationszugangs eine Gittertür aus der Licht scheint. \n" +
                        "Rote und aggressive Augen lurken aus der Dunkleheit hevor und blockieren dir den " +
                        "Zugang in den Turmkeller." + "\n" + monsters1.get(0).getName() + " greift dich an!",
                monsters1,
                false

        ));
        // Level 2
        List<Monster> monsters2 = new ArrayList<>();
        monsters2.add(new Monster(
                "Verpennter Gefängniswärter",
                "Dieser desorientierte und übermüdete Gefängniswärter kann hinterlistig erledigt werden.",
                40, 40, 7, 12, 20, 2));

        levels.add(new Map(
                "Kerker des dunklen Turms (Level 1)"
                        + "\n" + "Die Gittertür quietscht, als du sie hinter dir schließt. \n" +
                        " Du siehst einige Kerkerzellen mit Monstern die dich im Blick haben. \n" +
                        "Am Ende des Kerkerkomplexes schläft ein Gefängniswärter auf dem Holzhocker neben einem Sekretärtisch. \n"
                        + monsters2.get(0).getName() + " greift dich an!",
                monsters2,
                false

        ));
        // Level 3
        List<Monster> monsters3 = new ArrayList<>();
        monsters3.add(new Monster(
                "Wachsame Patrouille",
                "Patrouilliert den Kellerkomplex. ",
                60, 50, 10, 15, 25, 3));

        levels.add(new Map(
                "Kellerkorridore des dunklen Turms (Level 3)"
                        + "\n" + "Du verlässt vorsichtig den Kerker und gelangst in eine Korridorsystem.  \n" +
                        " Tatsächlich befinden sich Richtungspfeile mit Unterschrift unter den Laternen \n" +
                        "Du siehst das Schild ''Küche'' und vermutest dort weniger gutgepanzerte Gegner. \n" +
                        "Plötzlich hörst du aus einem Korridor eine Patrouille ''Eindringling!'' schreien und siehst, wie diese auf dich zurennt...\n "
                        + monsters3.get(0).getName() + " greift dich an!",
                monsters3,
                false

        ));
        // Level 4
        List<Monster> monsters4 = new ArrayList<>();
        monsters4.add(new Monster(
                "Besessener Küchenchef",
                "Dieser Koch scheint nicht mehr er selbst zu sein, sondern wirkt komplett besessen!",
                65, 65, 8, 13, 10, 4));

        levels.add(new Map(
                "Küche des dunklen Turms (Level 4)"
                        + "\n" + "Du betrittst die Küche und hoffst auf Zivilisten oder Angestellte, \n" +
                        " die dir nicht direkt an den Kragen wollen. \n" +
                        "Der cholerische Küchenchef hat aber bedrohliche lila leuchtende Augen und wirkt komplett besessen. \n" +
                        "Er blickt zu dir und schreit ''Eindringling! Aus dir mach ich Gulasch für den Meister!'' \n" +
                        " und macht sich mit seinem Küchenbeil bereit für den Kampf.\n"
                        + monsters4.get(0).getName() + " greift dich an!",
                monsters4,
                false

        ));

        // Level 5
        List<Monster> monsters5 = new ArrayList<>();
        monsters5.add(new Monster(
                "Unvorbereiteter Jäger",
                "Dieser Jäger erholt sich von einer langen Jagdtour und ist nicht vorbereitet für einen Hinterhalt",
                80, 75, 6, 14, 20, 5));

        levels.add(new Map(
                "Jagdraum des dunklen Turms (Level 5)"
                        + "\n" + "Die verängstigten Küchenhilfen zeigen mit einem Finger auf eine Holztür " +
                        "''Da ist der Ausgang - Bitte verschone uns!'' \n " +
                        " \n In der Tat ist dies die einzige Tür die nach oben führt. Du gehst hindurch und befindest \n" +
                        " dich in einem Raum für die Jäger. Hier erholen sie sich, wenn sie ihr erlegtes Wild zum Küchenchef bringen. \n" +
                        " Zum Glück scheint die Jagdtruppe unterwegs zu sein, da nur ein ausruhender Jäger am Kamin überrascht aufspringt. \n" +
                        " ''Ah, verdammt! Wo ist mein Bogen!?'' - statt zum Bogen greift er zu einem Speer, der dekorativ an der Wand hängt.\n"
                        + monsters5.get(0).getName() + " greift dich an!",
                monsters5,
                false
        ));
        // Level 6
        List<Monster> monsters6 = new ArrayList<>();
        monsters6.add(new Monster(
                "Mutiger Knappe",
                "Ein mutiger Knappe, der davon träumt ein Ritter zu werden",
                85, 80, 10, 15, 30, 6));

        levels.add(new Map(
                "Schlafgemach der Ritterkaserne im dunklen Turm (Level 6)"
                        + "\n" + "Neben dem Jagdraum befinden sich die Schlafgemächer der Ritter. \n" +
                        " Ein junger Knappe stellt sich dir entgegen, als du durch das Schlafgemacht schleichen willst!. \n" +
                        monsters6.get(0).getName() + " greift dich an!",
                monsters6,
                false

        ));
        // Level 7
        List<Monster> monsters7 = new ArrayList<>();
        monsters7.add(new Monster(
                "Kreuzritter",
                "Der Kreuzritter ist Mentor des mutigen Knappen",
                95, 90, 10, 15, 35, 7));

        levels.add(new Map(
                "Bedienstetengänge Teil 1 - (Level 7)"
                        + "\n" + "Du durchstreifst eine spezielle Route in den Bedienstetengängen. \n" +
                        " Hinter dir rennt ein Kreuzritter und stellt sich dir. Es ist der Ausbilder des Knappen. \n" +
                        "Er will Rache! \n" +
                        monsters7.get(0).getName() + " greift dich an!",
                monsters7,
                false

        ));
        // Level 8
        List<Monster> monsters8 = new ArrayList<>();
        monsters8.add(new Monster(
                "Hexenmeister-Akolyth",
                "Ein Anfänger der Hexenkunst.",
                100, 100, 10, 12, 35, 8));

        levels.add(new Map(
                "Bedienstetengänge Teil 2 - (Level 8)"
                        + "\n" + "Nachdem du auch den Kreuzritter geschlagen hast, rennst du schnell durch den \n" +
                        " Bedienstetengang zu dem Zugang in Richtung Turmherr \n" +
                        "Hinter dem Zugang erwartet dich ein junger Hexenmeister und will dich aufhalten \n"
                        + monsters8.get(0).getName() + " greift dich an!",
                monsters8,
                false

        ));
        // Level 9
        List<Monster> monsters9 = new ArrayList<>();
        monsters9.add(new Monster(
                "Kerberos",
                "Haustier von Ivan dem Schrecklichen",
                130, 125, 11, 15, 25, 9));

        levels.add(new Map(
                "Vorraum zum Foyer im dunklen Turm (Level 9)"
                        + "\n" + " Du sieht einen eindrucksvollen Foyer vor deinen Augen \n" +
                        " Du sprintest gen Foyer, ehe du von einem Hund mit drei Köpfen angesprungen wirst! \n" +
                        monsters9.get(0).getName() +" greift dich an!",
                monsters9,
                false

        ));

        // Level 10
        List<Monster> monsters10 = new ArrayList<>();
        monsters10.add(new Monster(
                "Mamorwächter (Boss Gegner)",
                "Ein riesiger Golem, der aus Marmor geschlagen wurde und jeden Eindringling gnadenlos zermalmt.",
                200, 200, 15, 20, 40, 10));
        levels.add(new Map(
                "Eindrucksvolles Foyer im dunklen Turm  (Level 10)"
                        + "\n" + "Du siehst einen großen Tür, umgeben von Statuen in einem Foyer-ähnlichen Raum \n" +
                        "\n Du gehst auf die große Tür zu, doch dann erwacht einer der Statuen zum Leben!" +
                        "''Eli...miniere... Eindringling!'' \n" + monsters10.get(0).getName() + " greift dich an!",

                monsters10,
                true

        ));
        // Level 11
        List<Monster> monsters11 = new ArrayList<>();
        monsters11.add(new Monster(
                "Banshee",
                "Eine schreiende Banshee, die durch die verlorenen " +
                        "Hallen streift und seit Jahren neue Opfer sucht.",
                160, 155, 10, 15, 30, 11));

        levels.add(new Map(
                "Oberer Teil des Dunklen Turms - Die verlorenen Hallen (Level 11)"
                        + "\n" + "Ein kalter Wind weht durch die verlassenen Hallen des dunklen Turms. \n" +
                        " Nur wenige Fackeln leuchten und du merkst, dass du dich final im oberen Teil des Turms befindest. \n" +
                        "Eine ohrenbetäubende Frauenstimme sucht dich heim. In der ferne siehst du ein Abbild einer Banshee " +
                        "in Form einer ausgemergelten Frau!" +
                        "\n" + monsters10.get(0).getName() + " greift dich an!",
                monsters11,
                false

        ));
        // Level 12
        List<Monster> monsters12 = new ArrayList<>();
        monsters12.add(new Monster(
                "Mächtiger Hexenmeister",
                "Berater und rechte Hand von Ivan dem Schrecklichen!",
                180, 190, 17, 20, 30, 12));

        levels.add(new Map(
                "Dunkler Turm - Turmspitze (Level 12)"
                        + "\n" + "Vor einem großen prächtigen Tor flackern bunte Flammen in Feuerschalen. \n" +
                        "Die Umgebung wirkt fast wie ein Labor eines mächtigen Zauberes. Aus der Dunkelheit \n" +
                        "taucht ein mächtiger Hexenmeister vor, der bedrohlich lila Flammen zaubern kann \n" +
                        monsters12.get(0).getName() + " greift dich an!",
                monsters12,
                false

        ));
        // Level 13
        List<Monster> monsters13 = new ArrayList<>();
        monsters13.add(new Monster(
                "Ivan der Schreckliche - Turmherr (Endboss)",
                "Vor dir steht der Herrscher des Turms - Ivan der Schreckliche!",
                25, 25, 20, 25, 58, 13));

        levels.add(new Map(
                "Herrschergemächer des dunklen Turms - Spitze des Turms (Endboss)"
                        + "\n" + "Nach all den düsteren Gängen erwartet dich ein prächtiger Saal mit Thron. \n" +
                        " Vor dir steht der Tyrann des Königreichs - Ivan der Schreckliche. \n" +
                        "Bezwinge Ivan und werde Held des Königreichs!",
                monsters13,
                true

        ));
    };

    public Map getLevel(){
        return levels.get(currentLevelIndex);
}

    // Method to calculate exp amount based on dungeon level
    public int calculateExpForLevel(int levelNumber) {
        // check if level is valid
        if (levelNumber >= 1 && levelNumber <= levels.size()) {
            // exp grows with each level
            return INITIAL_EXP * levelNumber;
        } else {
            throw new IllegalArgumentException("Ungültige Level-Nummer");
        }
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void increaseLevel() {
        if (currentLevelIndex < 12){
            currentLevelIndex++;
        } else {
            for (int i = 0; i <= 10; i++){
                System.out.println(" "); // Clear the console a bit
            }
            GameLogic.endgame();
        }

    }

}
