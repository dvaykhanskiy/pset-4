/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();

        in.close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {
      boolean complete = false;
      long sum = 0;
      while (complete == false) {
        System.out.print("Lower bound: ");
        long lowerBound = in.nextLong();
        System.out.print("Upper bound: ");
        long upperBound = in.nextLong();

        if (upperBound > lowerBound) {
          if (lowerBound % 2 != 0) {
            lowerBound ++;
          }
          if (upperBound % 2 != 0) {
            upperBound --;
          }

          do {
            sum += lowerBound;
            lowerBound += 2;
          } while (lowerBound <= upperBound);
          complete = true;
      }
    }
    System.out.printf("\n%,d\n", sum);
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
      System.out.print("\n");
      boolean complete = false;
      while (complete == false) {
        System.out.print("Positive integer: ");
        long posInt = in.nextLong();
        long intLength = String.valueOf(posInt).length();
        int oneDigit = 0;
        if (posInt > 0) {
          System.out.print("\n");
          for (int i = 0; i < intLength;) {
          oneDigit = (int) posInt % 10;
          posInt /= 10;
          System.out.print(oneDigit);
          if (posInt == 0) {
            System.out.print(".\n");
          } else {
            System.out.print(", ");
          }
          i++;
        }
        complete = true;
      }
    }
    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
      System.out.print("\n");
      boolean complete = false;
      while (complete == false) {
        System.out.print("Positive integer: ");
        long posInt = in.nextLong();
        long intLength = String.valueOf(posInt).length();
        int oneDigit = 0;
        int sum = 0;
        if (posInt > 0) {
          for (int i = 0; i < intLength;) {
          oneDigit = (int) posInt % 10;
          posInt /= 10;
          if (oneDigit % 2 == 1) {
            sum += oneDigit;
          }
          i++;
        }
        System.out.println("\n" + sum + ".\n");
        complete = true;
      }
    }
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      boolean complete = false;
      double sum = 0;
      double amountNumbers = 0;
      while (complete == false) {
        System.out.print("Non-negative integer: ");
        long nonNegInt = in.nextLong();
        if (nonNegInt < 0) {
          complete = true;
        } else {
          sum += nonNegInt;
          amountNumbers++;
        }
      }
      double average = sum / amountNumbers;
      System.out.printf("\n%,.2f.\n", average);
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
      System.out.print("\n");
      boolean complete = false;
      boolean isPrime = true;
      while (complete == false) {
        System.out.print("Non-negative integer: ");
        double nonNegInt = in.nextDouble();
        if (nonNegInt >= 0) {
          if (nonNegInt == 0 || nonNegInt == 1) {
            isPrime = false;
          } else {
          for (int i = 2; i <= Math.ceil(Math.sqrt(nonNegInt)); i++) {
            if ((nonNegInt % i) == 0) {
              isPrime = false;
            }
          }
          }
          complete = true;
        }
      }
      if (isPrime == false) {
        System.out.println("\nNot prime.\n");
      } else {
        System.out.println("\nPrime.\n");
      }
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {
      boolean complete = false;
      double fibbNum = 0;
      double oldFibb = 0;
      double moreOldFibb = 1;
      while (complete == false) {
        System.out.print("Positive integer: ");
        long posInt = in.nextLong();
        if (0 < posInt && posInt < 93) {
          for (int i = 0; i <= posInt; i++) {
            fibbNum = oldFibb + moreOldFibb;
            moreOldFibb = oldFibb;
            oldFibb = fibbNum;
          }
          complete = true;
        }
      }
      System.out.printf("\n%,.0f.\n", moreOldFibb);
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
      System.out.print("\n");
      boolean complete = false;
      while (complete == false) {
        System.out.print("Positive integer: ");
        long posInt = in.nextLong();
        if (posInt >= 1) {
          System.out.print("\n1, " + posInt);
          for (int i = 2; i <= posInt / i; i++) {
            if ((posInt % i) == 0) {
              System.out.print(", " + i + ", " + (posInt / i));
            }
          }
          System.out.print(".\n");
          complete = true;
        }
      }
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
      System.out.print("\n");
      boolean complete = false;
      while (complete == false) {
        System.out.print("Height: ");
        int height = in.nextInt();
        if (height > 0 && height < 25) {
          for (int i = 2; i <= height + 1; i++) {
            System.out.print("\n");
            for (int j = 0; j < (height + 1 - i); j++) {
              System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
              System.out.print("#");
            }
          }
          complete = true;
        }
      }
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {
      System.out.print("\n");
      System.out.print("\n");
      boolean complete = false;
      while (complete == false) {
        System.out.print("Height: ");
        int height = in.nextInt();
        if (height > 0 && height < 25) {
          for (int i = 2; i <= height + 1; i++) {
            System.out.print("\n");
            for (int j = 0; j < (height + 1 - i); j++) {
              System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
              System.out.print("#");
            }
            System.out.print("  ");
            for (int k = 0; k < i; k++) {
              System.out.print("#");
            }
          }
          complete = true;
        }
      }
    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {
      System.out.print("\n");
      System.out.print("\n");
      int sum1 = 0;
      int sum2 = 0;
      String sum1String = "";
      System.out.print("Number: ");
      long cardNumber = in.nextLong();

      while (cardNumber <= 0) {
          System.out.print("Number: ");
          cardNumber = in.nextLong();
      }

      String cardType = "Invalid";

      String cardString = Long.toString(cardNumber);
      for (int i = cardString.length() - 2; i > -1; i -= 2) {
        sum1String += Integer.toString(2 * Integer.parseInt(cardString.substring(i, i + 1)));
      }
      for (int j = sum1String.length() - 1; j >= 0; j --) {
        sum1 += Integer.parseInt(sum1String.substring(j, j + 1));
      }

      for (int k = cardString.length() - 1; k >= 0; k -= 2 ) {
        sum2 += Integer.parseInt(cardString.substring(k, k + 1));
      }

      if (cardString.length() == 15 && (cardString.substring(0, 2).equals("37") || cardString.substring(0, 2).equals("34")) && ((sum1 + sum2) % 10 == 0)) {
        cardType = "Amex";
      }  else if ((cardString.length() == 16 || cardString.length() == 13) && ((sum1 + sum2) % 10 == 0) && (cardString.substring(0, 1).equals("4"))) {
        cardType = "Visa";
      } else if (cardString.length() == 16 && ((sum1 + sum2) % 10 == 0)) {
        switch (cardString.substring(0, 2)) {
         case "51":
           cardType = "Mastercard";
           break;
         case "52":
           cardType = "Mastercard";
           break;
         case "53":
           cardType = "Mastercard";
           break;
         case "54":
           cardType = "Mastercard";
           break;
         case "55":
           cardType = "Mastercard";
           break;
      }
  }

        System.out.print("\n" + cardType + ".\n\n");
    }
}
