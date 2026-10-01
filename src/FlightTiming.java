import java.util.Scanner;

/* ================= FlightTiming Class ================= */
class FlightTiming {

    static String timings[] = new String[50];

    static int timingCount = 4;

    static {
        timings[0] = "06:00 AM";
        timings[1] = "10:30 AM";
        timings[2] = "03:15 PM";
        timings[3] = "09:00 PM";
    }

    String chooseTiming(Scanner sc) {

        while (true) {

            System.out.println("================================");
            System.out.println("✈️ Available Flights");

            for (int i = 0; i < timingCount; i++)
                System.out.println((i + 1) + ". Flight " + (100 + i) + " - " + timings[i]);

            System.out.print("➡️ Choose flight: ");

            int choice = sc.nextInt();

            if (choice >= 1 && choice <= timingCount)
                return timings[choice - 1];

            System.out.println("❌ Invalid input. Try again.");
        }
    }

    static void addTiming(String newTiming) {

        timings[timingCount] = newTiming;
        timingCount++;

        System.out.println("✅ New flight timing added successfully");
    }
}
