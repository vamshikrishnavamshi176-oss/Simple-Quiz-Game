package Question;

class Question {
	String question;
	String[] options;
	int correctAnswer;
	int [] poll;
	String level;

	Question(String level, String question, String[] options,int []poll, int correctAnswer) {
		this.level = level;
		this.question = question;
		this.options = options;
		this.correctAnswer = correctAnswer;
		this.poll = poll;
	}
}
/*
 *sample question 
 *structure of the question is defined like this.
 * LEVEL 1
 * What is the capital of India?
 * Mumbai,Delhi,Chennai,Kolkata,LifeLine 
 * 2
 * POLL:20,60,10,10,0
 */