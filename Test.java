public class Test {
  public static void main(String[] args) {
    // Perform tests
    String test1 = TimeManager.AddMinutes("1:24 AM", 10);
    assert(test1.equals("1:34 AM"));
    String test2 = TimeManager.AddMinutes("11:44 PM", 17);
    assert(test2.equals("12:01 AM"));
    String test3 = TimeManager.AddMinutes("3:44 PM", 1000);
    assert(test3.equals("8:24 AM"));
    String test4 = TimeManager.AddMinutes("12:00 AM", 1439);
    assert(test4.equals("11:59 PM"));
    String test5 = TimeManager.AddMinutes("12:00 AM", 1441);
    assert(test5.equals("12:01 AM"));
    String test6 = TimeManager.AddMinutes("2:08 AM", 5000);
    assert(test6.equals("1:28 PM"));
    String test7 = TimeManager.AddMinutes("9:13 AM", 200);
    assert(test7.equals("12:33 PM"));
    String test8 = TimeManager.AddMinutes("9:13 AM", 48);
    assert(test8.equals("10:01 AM"));
    String test9 = TimeManager.AddMinutes("11:57 AM", 719);
    assert(test9.equals("11:56 PM"));
    String test10 = TimeManager.AddMinutes("11:57 AM", 725);
    assert(test10.equals("12:02 AM"));
    String test11 = TimeManager.AddMinutes("11:57 AM", 2165);
    assert(test11.equals("12:02 AM"));
    String test12 = TimeManager.AddMinutes("10:12 PM", 183);
    assert(test12.equals("1:15 AM"));
    String test13 = TimeManager.AddMinutes("10:12 PM", 229);
    assert(test13.equals("2:01 AM"));
    String test14 = TimeManager.AddMinutes("1:59 PM", 417);
    assert(test14.equals("8:56 PM"));
    String test15 = TimeManager.AddMinutes("3:40 AM", -8);
    assert(test15.equals("3:32 AM"));
    String test16 = TimeManager.AddMinutes("12:01 AM", -3);
    assert(test16.equals("11:58 PM"));
    String test17 = TimeManager.AddMinutes("3:44 PM", -1000);
    assert(test17.equals("11:04 PM"));
    String test18 = TimeManager.AddMinutes("12:00 PM", -719);
    assert(test18.equals("12:01 AM"));
    String test19 = TimeManager.AddMinutes("1:21 PM", -5000);
    assert(test19.equals("2:01 AM"));
    String test20 = TimeManager.AddMinutes("1:21 PM", -5130);
    assert(test20.equals("11:51 PM"));
    // Invalid input
    String test21 = TimeManager.AddMinutes("1:21PM", -5);
    assert(test21.equals(""));
    String test22 = TimeManager.AddMinutes("1:21", 10);
    assert(test22.equals(""));
    String test23 = TimeManager.AddMinutes("1:21 FM", 10);
    assert(test23.equals(""));
    String test24 = TimeManager.AddMinutes("time", 10);
    assert(test24.equals(""));
  }
}
