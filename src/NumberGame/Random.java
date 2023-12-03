package NumberGame;

import javax.swing.JOptionPane;

public class Random {

	public static void main(String[] args) {

		int min = 1;
		int max = 100;
		int response = 1;
		int random = 0;
		int score = 0;
		JOptionPane.showMessageDialog(null, "Guess the Number from 1-100" + "\nYou have 5 chances to win \nGood luck!",
				"Welcome to Number Guessing Game", JOptionPane.PLAIN_MESSAGE);

		do {
			random = (int) (Math.random() * (max - min + 1) + min);

			int turns = 5;
			int attempts = 0;

			if (random % 2 == 0) {
				JOptionPane.showMessageDialog(null, "Hint: Even Number");
			} else {
				JOptionPane.showMessageDialog(null, "Hint: Odd2 Number");
			}

			while (turns-- > 0) {

				int num = Integer.parseInt(JOptionPane.showInputDialog("Enter your Guess"));
				attempts++;
				Object[] options = { "try again" };

				if (random == num) {
					JOptionPane.showMessageDialog(null, "Your Guess is Correct");
					JOptionPane.showMessageDialog(null, "You took " + attempts + " attempts to win");
					score++;
					break;
				}

				else if (num < random && Math.abs(random - num) <= 10) {
					JOptionPane.showOptionDialog(null, "You are close! The entered num is a bit low", "Number Game",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}

				else if (num > random && Math.abs(random - num) <= 10) {
					JOptionPane.showOptionDialog(null, "You are close! The entered num is a bit high", "Number Game",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}

				else if (num > random && num - random >= 30) {
					JOptionPane.showOptionDialog(null, "Too high", "Number Game", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}

				else if (num > random && num - random < 30) {
					JOptionPane.showOptionDialog(null, "The num is high", "Number Game", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}

				else if (num < random && random - num >= 30) {
					JOptionPane.showOptionDialog(null, "Entered num is too low", "Number Game",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}

				else if (num < random && random - num < 30) {
					JOptionPane.showOptionDialog(null, "Entered num is low", "Number Game", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}

				if (turns == 0 && random != num) {
					JOptionPane.showMessageDialog(null,
							"You have exceeded the attempts" + "\nThe correct num is " + random);

				}

			}

			JOptionPane.showMessageDialog(null, "Your score -" + score);

			response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Number Game",
					JOptionPane.YES_NO_OPTION);

		} while (response == 0);

	}
}
