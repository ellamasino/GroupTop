public class AdventureStage {
    private String description;
    private String[] choices;

    public AdventureStage(String description, String[] choices) {
        this.description = description;
        this.choices = choices;
    }

    public void displayStage() {
        System.out.println(description);
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    public int getChoicesCount() {
        return choices.length;
    }
}
