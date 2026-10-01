import java.util.Scanner;

class AdminFlightManager extends Admin {

    void adminMenu(
            Scanner sc,
            Flight flightList[],
            SeatPattern seatList[],
            int flightCountWrapper[]
    ) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("🛠️ ADMIN MENU");
            System.out.println("================================");
            System.out.println("1. Create Flight");
            System.out.println("2. Delete Flight");
            System.out.println("3. View Flights");
            System.out.println("4. Exit Admin");
            System.out.println("================================");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("🆕 Creating new flight");

                    Destination dest = new Destination();
                    FlightTiming timing = new FlightTiming();

                    String source = dest.choosePlace("Source", sc);
                    String destination = dest.choosePlace("Destination", sc);

                    DepartureDate date = DepartureDate.inputDate(sc);

                    String time = timing.chooseTiming(sc);
                    FlightTiming.addTiming(time);

                    Flight newFlight =
                            new Flight(101 + flightCountWrapper[0], 30);

                    newFlight.setDetails(source, destination, time, date);

                    flightList[flightCountWrapper[0]] = newFlight;

                    seatList[flightCountWrapper[0]] =
                            new SeatPattern();

                    flightCountWrapper[0]++;

                    System.out.println("✅ Flight created successfully");

                    break;

                case 2:

                    System.out.print("Enter Flight Number to delete: ");

                    int fno = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < flightCountWrapper[0]; i++) {

                        if (flightList[i].flightNo == fno) {

                            for (int j = i;
                                 j < flightCountWrapper[0] - 1;
                                 j++) {

                                flightList[j] = flightList[j + 1];
                                seatList[j] = seatList[j + 1];
                            }

                            flightCountWrapper[0]--;

                            System.out.println("✅ Flight deleted");

                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("❌ Flight not found");

                    break;

                case 3:

                    if (flightCountWrapper[0] == 0)
                        System.out.println("No flights available");
                    else
                        for (int i = 0;
                             i < flightCountWrapper[0];
                             i++)
                            flightList[i].displayFlight();

                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}