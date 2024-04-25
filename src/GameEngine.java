import java.util.Scanner;

public class GameEngine {
    private AdventureStage[] stages;
    private Scanner scanner;
    //#

    public GameEngine() {
        scanner = new Scanner(System.in);
        stages = new AdventureStage[]{
                new AdventureStage("You are at the entrance of a lost temple. There's a dark passage ahead and a ladder leading down.", new String[]{"Enter the passage", "Go down the ladder"}),
                new AdventureStage("You enter the passage and find a chamber with two doors. One door is covered in ancient runes.", new String[]{"Open the rune door", "Open the other door"}),
                new AdventureStage("You climb down the ladder into a pit with snakes. You see a lever on the other side.", new String[]{"Go back up", "Move towards the lever"})
        };
    }

    public void startAdventure() {
        int currentStage = 0;
        while (currentStage < stages.length) {
            stages[currentStage].displayStage();
            int choice = getUserChoice(stages[currentStage].getChoicesCount());
            currentStage = determineNextStage(currentStage, choice);
            if (currentStage == -1) {
                System.out.println("Game over. Thanks for playing!");
                break;
            }
        }
    }

    private int getUserChoice(int choicesCount) {
        int choice = scanner.nextInt();
        while (choice < 1 || choice > choicesCount) {
            System.out.println("Invalid choice, try again.");
            choice = scanner.nextInt();
        }
        return choice - 1; // adjust for 0-based index
    }

    private int determineNextStage(int currentStage, int choice) {
        // This is a simplified example of stage progression logic
        if (currentStage == 1 && choice == 0) {
            System.out.println("You touched a cursed door and met a grim fate!");
            return -1; // game over
        }
        return currentStage + 1; // go to the next stage by default
    }
}
