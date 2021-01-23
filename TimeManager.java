import java.util.Scanner;

/* Name: Spencer Gable-Cook
 * Date: January 22, 2021
 * Version: v0
 * Description:
 *    This program implements and tests the AddMinutes function
 */

class TimeManager {
   // Define global constant variables
  private static final int NUMBER_MINUTES_NOON = 12 * 60;
  private static final int NUMBER_MINUTES_DAY = 24 * 60;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the AddMinutes Calculator!");

    // Test function with user inputs
    String newTime = "";
    String timeString = "";
    int minutesToAdd = 0;
    do {
      System.out.print("Please input the time according to the following format: \"[H]H:MM {AM|PM}\": ");
      timeString = scanner.nextLine();
      System.out.print("How many minutes would you like to add?: ");
      minutesToAdd = scanner.nextInt();
      scanner.nextLine();

      // Call the 'AddMinutes' function with the input
      newTime = AddMinutes(timeString, minutesToAdd);
    } while (newTime.equals("")); // repeat if there is invalid input
    scanner.close();

    // Output results
    System.out.println(minutesToAdd + " minutes after " + timeString + " is " + newTime);
  }

  private static int getNumberFromTime(String number) {
    // Try and catch to get number if it is a valid number
    try {
      int parsedInt = Integer.parseInt(number);
      return parsedInt;
    } catch (NumberFormatException e) {
      // Not a valid number; return -1 to show that it is an error
      return -1;
    }
  }

  public static String AddMinutes(String timeString, int numberOfMinutes) {
    // Split timeString into hours, minutes, and AM/PM into string array
    // Split by : for 'hours:minutes' and a space for 'minutes AM/PM'
    String[] components = timeString.split(":|\\ ");
    // Ensure that there are 3 components --> the hour, minute, and AM/PM. If not, this is invalid input!
    if (components.length != 3) {
      // Invalid input!
      System.out.println("Invalid input! Please try again!");
      return "";
    }
    // 'Hour' is the first element of the components array
    int hour = getNumberFromTime(components[0]);
    // 'Minutes' is the second element of the components array
    int minutes = getNumberFromTime(components[1]);
    // 'AM/PM' is the third element of the components array
    String timeOfDay = components[2];
    // Check that valid input has been received!
    if ((hour > 12 || hour < 1) || (minutes < 0 || minutes > 60) || !(timeOfDay.equals("AM") || timeOfDay.equals("PM"))) {
      // Invalid input!
      System.out.println("Invalid input! Please try again!");
      return "";
    }

    // Convert the hours and minutes into the total number of minutes after midnight.
    // This way, we can easily add numberOfMinutes to this value to get the new time
    int totalMinutes = (hour % 12) * 60 + minutes;
    // If the time is PM, then add the number of minutes at noon
    if (timeOfDay.equals("PM")) {
      totalMinutes += NUMBER_MINUTES_NOON;
    }
    // Add 'numberOfMinutes' to this total
    totalMinutes += numberOfMinutes;
    // Check if 'totalMinutes' overflows the total minutes in a day.
    // If this is the case, then it must wrap around to the next day.
    if (totalMinutes >= NUMBER_MINUTES_DAY) {
      totalMinutes = totalMinutes % NUMBER_MINUTES_DAY;
    }

    // Now, convert the raw minutes back into a time format
    String newTimeOfDay = "AM";
    // First, get if the new time is AM or PM
    if (totalMinutes >= NUMBER_MINUTES_NOON) {
      totalMinutes -= NUMBER_MINUTES_NOON;
      newTimeOfDay = "PM";
    }
    // Convert totalMinutes back to hour and minute format
    int newHour = totalMinutes / 60;
    if (newHour == 0) {
      newHour = 12;
    }
    int newMinutes = totalMinutes % 60;

    // Finally, create string that will contain the new time
    // Format minutes so that it has 2 digits
    String minuteFormat = "";
    if (newMinutes < 10) {
      minuteFormat = "0";
    }
    String newTime = Integer.toString(newHour) + ":" + minuteFormat + Integer.toString(newMinutes) + " " + newTimeOfDay;
    return newTime;
  }
}
