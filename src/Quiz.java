import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz implements Serializable {
    private String name;
    private int numCorrect;
    private ArrayList<Question> questions;

    public Quiz(String name) {
        this.questions = new ArrayList<>();
        this.name = name;
        this.numCorrect = 0;
    }

    public String getName() {
        return name;
    }

    public void addWord(Question question) {
        questions.add(question);
    }

    public void run(final Scanner inputHandler) {
        Collections.shuffle(questions);

        for (Question question : questions) {
            System.out.println(question.getWord());
            System.out.print("Definition: ");

            String userDefinition = inputHandler.nextLine().trim();
            String wordDefinition = question.getDefinition().trim();

            if (userDefinition.equalsIgnoreCase(wordDefinition)) {
                System.out.println("Correct!");
                numCorrect++;
            } else {
                System.out.println("WRONG NOOB");
            }
        }
        System.out.println("You got " + numCorrect + " out of " + questions.size() + " right\n");
        numCorrect = 0;
    }

}
