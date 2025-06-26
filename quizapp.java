import java.util.Scanner;

class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question[] questions = new Question[3];

        questions[0] = new Question(
            "What is the capital of India?",
            new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"},
            2
        );

        questions[1] = new Question(
            "Which language runs in a web browser?",
            new String[]{"Java", "C++", "Python", "JavaScript"},
            4
        );

        questions[2] = new Question(
            "Which keyword is used to define a class in Java?",
            new String[]{"function", "class", "struct", "interface"},
            2
        );

        int score = 0;

        System.out.println("=== Welcome to the Quiz App ===");

        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\nYour final score: " + score + " out of " + questions.length);

        sc.close();
    }
}

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    boolean askQuestion(Scanner sc) {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your choice (1-4): ");
        int userChoice = sc.nextInt();
        return userChoice == correctAnswer;
    }
}