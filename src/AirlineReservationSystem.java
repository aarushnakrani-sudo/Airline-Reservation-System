import java.util.Scanner;

/* ================= Main Class ================= */
class AirlineReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Destination dest = new Destination();
        FlightTiming timing = new FlightTiming();

        Flight flightList[] = new Flight[50];
        SeatPattern seatList[] = new SeatPattern[50];

        int flightCount = 0;
        int booked = 0;
        int cancelled = 0;
        AdminFlightManager adminManager =
                new AdminFlightManager();

        int flightCountWrapper[] = {flightCount};
        while (true) {
            System.out.println("\n================================");
            System.out.println("Select Role");
            System.out.println("1. Passenger");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.println("================================");
            System.out.print("Enter Your role : ");

            int role = sc.nextInt();
            if (role == 1) {
                while (true) {

                    System.out.println("\n================================");
                    System.out.println("✈️ AIRLINE RESERVATION SYSTEM ✈️");
                    System.out.println("================================");
                    System.out.println("1. Book Ticket 🎫");
                    System.out.println("2. Show Flight ✈️");
                    System.out.println("3. Show Seats 💺");
                    System.out.println("4. Report 📊");
                    System.out.println("5. Exit 🚪");
                    System.out.println("================================");

                    System.out.print("➡️ Choice: ");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            System.out.println("================================");
                            System.out.print("🆔 Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            String name;
                            while (true) {

                                System.out.print("🧾 Enter Name: ");
                                name = sc.nextLine();

                                boolean valid = true;

                                for (char ch : name.toCharArray())
                                    if (!Character.isLetter(ch) && ch != ' ')
                                        valid = false;

                                if (valid && name.length() > 0)
                                    break;

                                System.out.println("❌ Invalid input. Enter name again.");
                            }

                            int age;
                            while (true) {

                                System.out.print("🎂 Enter Age: ");
                                age = sc.nextInt();

                                if (age >= 1 && age <= 100)
                                    break;

                                System.out.println("❌ Invalid age. Enter again.");
                            }

                            Passenger p = new Passenger(id, name, age);
                            Guardian g = null;

                            if (age < 18) {

                                sc.nextLine();

                                System.out.println("================================");
                                System.out.println("🛡️ Guardian Required");

                                System.out.print("🧾 Guardian Name: ");
                                String gname = sc.nextLine();

                                System.out.print("🎂 Guardian Age: ");
                                int gage = sc.nextInt();
                                sc.nextLine();

                                System.out.print("🤝 Relation: ");
                                String rel = sc.nextLine();

                                g = new Guardian(gname, gage, rel);
                            }

                            DepartureDate date = DepartureDate.inputDate(sc);

                            if (!date.isWithin3Months()) {
                                System.out.println("❌ Booking allowed only within 3 months");
                                break;
                            }

                            String source;
                            String destination;

                            while (true) {

                                source = dest.choosePlace("Source", sc);
                                destination = dest.choosePlace("Destination", sc);

                                if (source.equals(destination))
                                    System.out.println("❌ Source and destination cannot be same.");
                                else
                                    break;
                            }

                            String time = timing.chooseTiming(sc);

                            Flight selectedFlight = null;
                            SeatPattern selectedSeats = null;

                            for (int i = 0; i < flightCount; i++) {

                                if (flightList[i].source.equals(source) &&
                                        flightList[i].destination.equals(destination) &&
                                        flightList[i].timing.equals(time) &&
                                        flightList[i].date.day == date.day &&
                                        flightList[i].date.month == date.month &&
                                        flightList[i].date.year == date.year) {

                                    selectedFlight = flightList[i];
                                    selectedSeats = seatList[i];

                                    System.out.println("🔄 Using existing flight");
                                    break;
                                }
                            }

                            if (selectedFlight == null) {

                                selectedFlight = new Flight(101 + flightCount, 30);
                                selectedFlight.setDetails(source, destination, time, date);

                                selectedSeats = new SeatPattern();

                                flightList[flightCount] = selectedFlight;
                                seatList[flightCount] = selectedSeats;

                                flightCount++;

                                System.out.println("🆕 New flight created");
                            }

                            int price = selectedSeats.bookSeat(sc);

                            new Reservation(p, g, selectedFlight);
                            new Transaction(price).showTransaction();

                            booked++;
                            if (g != null) {

                                System.out.println("\nBook Seat for Guardian");

                                int guardianPrice = selectedSeats.bookSeat(sc);

                                new Transaction(guardianPrice).showTransaction("Guardian seat booked");

                                selectedFlight.availableSeats--;

                                booked++;
                            }
                            break;

                        case 2:

                            if (flightCount == 0)
                                System.out.println("❌ No flights available.");
                            else
                                for (int i = 0; i < flightCount; i++)
                                    flightList[i].displayFlight();

                            break;

                        case 3:

                            if (flightCount == 0)
                                System.out.println("❌ No seat data available.");
                            else {

                                System.out.print("✈️ Enter Flight Number: ");
                                int fno = sc.nextInt();

                                boolean found = false;

                                for (int i = 0; i < flightCount; i++) {

                                    if (flightList[i].flightNo == fno) {

                                        seatList[i].displaySeats();
                                        found = true;
                                        break;
                                    }
                                }

                                if (!found)
                                    System.out.println("❌ Flight not found.");
                            }

                            break;

                        case 4:

                            Report report = new Report(booked, cancelled);
                            report.showReport();

                            break;

                        case 5:
                            System.out.println("👋 Thank you for using Airline Reservation System!");
                            System.exit(0);

                        default:
                            System.out.println("❌ Invalid choice. Try again.");
                    }
                }
            } else if (role == 2 && adminManager.login(sc)) {

                adminManager.adminMenu(
                        sc,
                        flightList,
                        seatList,
                        flightCountWrapper
                );

                flightCount = flightCountWrapper[0];
            } else if (role == 3) {

                System.out.println("👋 Exiting system...");
                System.exit(0);
            } else {

                System.out.println("❌ Invalid role selection.");
            }
        }
    }
}