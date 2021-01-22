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
    System.out.println(AddMinutes("12:33 AM", 100));
  }

  public static String AddMinutes(String timeString, int numberOfMinutes) {
    // Split timeString into hours, minutes, and AM/PM into string array
    // Split by : for 'hours:minutes' and a space for 'minutes AM/PM'
    String[] components = timeString.split(":|\\ ");
    // 'Hour' is the first element of the components array
    int hour = Integer.parseInt(components[0]);
    // 'Minutes' is the second element of the components array
    int minutes = Integer.parseInt(components[1]);
    // 'AM/PM' is the third element of the components array
    String timeOfDay = components[2];

    // Convert the hours and minutes into the total number of minutes after midnight.
    // This way, we can easily add numberOfMinutes to this value to get the new time
    int totalMinutes = hour * 60 + minutes;

    return "Hello";
  }
}
