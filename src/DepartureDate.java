import java.util.Scanner;

/* ================= DepartureDate Class ================= */
class DepartureDate {

    int day, month, year;

    DepartureDate(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    static DepartureDate inputDate(Scanner sc) {

        while (true) {
            System.out.println("================================");
            System.out.println("📅 Enter Departure Date");
            System.out.println("*Note:Booking allowed only within 3 months*");
            System.out.print("\n1.Date: ");
            int d = sc.nextInt();

            System.out.print("2.Month: ");
            int m = sc.nextInt();

            System.out.print("3.Year: ");
            int y = sc.nextInt();

            if (d >= 1 && d <= 31 && m >= 1 && m <= 12 && y >= 2026)
                return new DepartureDate(d, m, y);

            System.out.println("❌ Invalid date. Please enter again.");
        }
    }

    boolean isWithin3Months() {

        int currentDay = 1;
        int currentMonth = 2;
        int currentYear = 2026;

        int currentTotal = currentYear * 365 + currentMonth * 30 + currentDay;
        int enteredTotal = year * 365 + month * 30 + day;

        int diff = enteredTotal - currentTotal;

        return diff >= 0 && diff <= 90;
    }

    void displayDate() {
        System.out.println("🗓️ Departure Date: " + day + "/" + month + "/" + year);
    }
}