import java.util.Scanner;

/* ================= SeatPattern Class ================= */
class SeatPattern {

    char seats[][] = new char[5][6];

    // ANSI Color Codes
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";

    SeatPattern() {

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 6; j++)
                seats[i][j] = 'O';
    }

    void displaySeats() {

        System.out.println("================================");
        System.out.println("💺 Seat Layout");
        System.out.println("   A B C   D E F");

        for (int i = 0; i < 5; i++) {

            System.out.print((i + 1) + "  ");

            for (int j = 0; j < 6; j++) {

                if (seats[i][j] == 'O')
                    System.out.print(GREEN + "O " + RESET);
                else
                    System.out.print(RED + "X " + RESET);

                if (j == 2)
                    System.out.print("  ");
            }

            System.out.println();
        }
    }

    int bookSeat(Scanner sc) {

        while (true) {

            displaySeats();

            System.out.print("🪑 Enter Row (1-5): ");
            int row = sc.nextInt() - 1;

            System.out.print("🪑 Enter Seat Letter (A-F): ");
            char colChar = Character.toUpperCase(sc.next().charAt(0));

            int col = colChar - 'A';

            if (row >= 0 && row < 5 && col >= 0 && col < 6) {

                if (seats[row][col] == 'O') {

                    seats[row][col] = 'X';

                    int price;

                    if (colChar == 'A' || colChar == 'F')
                        price = 6000;
                    else
                        price = 4500;

                    System.out.println("✅ Seat Booked!");
                    System.out.println("💸 Seat Price: ₹" + price);

                    return price;
                } else
                    System.out.println("❌ Seat already booked. Try another seat.");
            } else
                System.out.println("❌ Invalid input. Try again.");
        }
    }
}