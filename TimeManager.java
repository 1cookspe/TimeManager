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
    System.out.println(totalMinutes);

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
    String newTime = Integer.toString(newHour) + ":" + Integer.toString(newMinutes) + " " + newTimeOfDay;
    return newTime;
  }
}
