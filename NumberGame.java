import java.util.Random;
import java.util.Scanner;

 class GuessNumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts =5;
        int totalRounds = 0;
        int score = 0;

        System.out.println("\nWELCOME TO THE NUMBER GAME");

        boolean playAgain = true;

        while(playAgain) {

            int generatedNumber = randomNumber.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound: " + (totalRounds + 1));
            System.out.println("\nSystem has generated a number between " + minNumber + " and " + maxNumber + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");
            totalRounds++;

            while(attempts < maxAttempts && !guessedCorrectly) {
                System.out.println("\nAttempt: " + (attempts + 1) + "/" + maxAttempts);
                System.out.print("Enter your guess Number :: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();

                if (userGuess < generatedNumber) {
                    System.out.println("\nIt's too low!");
                }
                
                else if (userGuess > generatedNumber) {
                    System.out.println("\nIt's too high!");
                }
                
                else {
                    System.out.println(" You guessed the right one.");
                    guessedCorrectly = true;
                    score++;
                }

                attempts++;
            }

            if (!guessedCorrectly) {

                System.out.println("\nOops! You have used up all your attempts.");
                System.out.println("The correct number was: " + generatedNumber);
            }

            System.out.print("\nWould you like to play this game again? (Yes/No) :: ");
            String playAgainResponse = scanner.nextLine();

            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
         System.out.println("\nGame over! ");
        System.out.println("\n Your score is: " + score);

        System.out.println("Thanks for playing!");
    }
}