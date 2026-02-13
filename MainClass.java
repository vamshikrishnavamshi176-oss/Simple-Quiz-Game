package Question;

import java.util.*;

public class MainClass {
	private static final String GREEN = "\u001B[32m";
	private static final String RED = "\u001B[31m";
	private static final String RESET = "\u001B[0m";
	private static final String WIN = "\u001B[33m";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Question> questions = QuestionLoader.loadQuestions("GeneralQuizQuestions.txt");
		int money = 0;

		System.out.println("...Welcome to Quiz...");
		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		for (Question q : questions) {

			System.out.println("\n" + q.level);
			System.out.println("Q: " + q.question);

			for (int i = 0; i < q.options.length; i++) {
				System.out.println((i + 1) + ". " + q.options[i]);
			}
			System.out.print("Enter your answer (1-5): ");
			int userAnswer = sc.nextInt();
			if (userAnswer >= 1 && userAnswer < 6) {
				if (userAnswer == 5) {
					System.out.println("-----------------------");
					System.out.println("1. 50-50\n2. Audience Pole");
					System.out.println("-----------------------");
					int choice = sc.nextInt();
					if (choice == 1) {
						Lifeline.useFifty(q);
					} else if (choice == 2) {
						Lifeline.useAudience(q);
					} else {
						System.out.println(RED + "Invalid choice" + RESET);
						break;
					}
					System.out.println("Enter the final choice(1-4): ");
					userAnswer = sc.nextInt();
				}
				if (userAnswer == q.correctAnswer) {
					money += 1000;
					System.out.println(GREEN + "Correct!\t\tTotal Money: ₹" + money + RESET);
				} else {
					System.out.println(RED + "Wrong Answer!\tTotal Money : ₹" + money + RESET);
					break;
				}
			} else {
				System.out.println(RED + "Invalid choice" + RESET);
				break;
			}

			System.out.println(WIN + "\n" + name + " you won ₹" + money + RESET);
		}
		
		sc.close();
	}
}
