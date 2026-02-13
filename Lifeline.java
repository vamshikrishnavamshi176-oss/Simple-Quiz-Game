package Question;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lifeline {
	private static final String RED = "\u001B[31m";
	private static final String RESET = "\u001B[0m";
	
	public static boolean fiftyused = false;
	public static boolean AudiencePole = false;

//	50-50 class
	public static void useFifty(Question q) {
		if (fiftyused) {
			System.out.println(RED+"Already used !"+RESET);
			return;
		}
		fiftyused = true;

		Set<Integer> set = new HashSet<>();
		set.add(q.correctAnswer);

		Random ran = new Random();
		while (set.size() < 2) {
            int x = ran.nextInt(4) + 1;
            if (x != q.correctAnswer) {
                set.add(x);
            }
        }
		System.out.println("\n🎯 50:50 Lifeline:");
		for (int i = 1; i <= 4; i++) {
			if (set.contains(i)) {
				System.out.println(i + ". " + q.options[i - 1]);
			}
		}

	}
	
//		Audience pole
	public static void useAudience(Question q) {
		if(AudiencePole) {
			System.out.println(RED+"Already used !"+RESET);
			return;
		}
		AudiencePole = true;
		
		for(int i=0;i<4;i++) {
			System.out.println((i + 1) + ". " + q.options[i] + " → " + q.poll[i] + "%");
		}
	}
}
