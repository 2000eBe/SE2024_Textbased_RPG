public class GameUtility {

    // Method to format dialogues a little bit prettier
    public static void printSeperator(int n){
        for (int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static String nextLine(){
        return Main.userinput.nextLine();
    }

    // Method to print a heading
    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }
    // Method to get user input from console
    public static int readInt(String prompt, int userChoice){
        int input;

        do {
            System.out.println(prompt);
            try{
                input = Integer.parseInt(Main.userinput.next());
            } catch (Exception e){
                input = -1;
                System.out.println("Bitte ein Integer einfügen!");
            }
        } while (input < 1 || input > userChoice);
        return input;
    }

}
