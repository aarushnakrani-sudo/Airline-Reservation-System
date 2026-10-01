import java.util.Scanner;

/* ================= Destination Class ================= */
class Destination {

    String[] places = {"Mumbai", "Delhi", "Bengaluru", "Chennai", "Kolkata"};

    String choosePlace(String type, Scanner sc) {

        while (true) {
            System.out.println("================================");
            System.out.println("🌏 Choose " + type);

            for (int i = 0; i < places.length; i++)
                System.out.println((i + 1) + ". " + places[i]);

            System.out.print("➡️ Enter choice: ");

            int choice = sc.nextInt();

            if (choice >= 1 && choice <= places.length)
                return places[choice - 1];

            System.out.println("❌ Invalid input. Try again.");
        }
    }
}