package Question;

import java.io.*;
import java.util.*;

class QuestionLoader {

	static List<Question> loadQuestions(String fileName) {

		List<Question> questions = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			String currentLevel = "";

			while ((line = br.readLine()) != null) {

				// Skip empty lines
				if (line.trim().isEmpty()) {
					continue;
				}

				// Detect LEVEL
				if (line.startsWith("LEVEL")) {
					currentLevel = line;
					continue;
				}
				 if (line.isEmpty()) continue;
				// Read question data
				String question = line;
				String[] options = br.readLine().split(",");
				int answer = Integer.parseInt(br.readLine());
				String pollLine = br.readLine().trim();
				pollLine = pollLine.replace("POLL:", "");

				String[] pollParts = pollLine.split(",");
				int[] poll = new int[pollParts.length];

				for (int i = 0; i < pollParts.length; i++) {
					poll[i] = Integer.parseInt(pollParts[i].trim());
				}
				questions.add(new Question(currentLevel, question, options, poll, answer));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return questions;
	}
}
