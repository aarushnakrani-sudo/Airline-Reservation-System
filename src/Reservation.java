/* ================= Reservation Class ================= */
class Reservation {

    Reservation(Passenger p, Guardian g, Flight f) {

        f.availableSeats--;
        System.out.println("================================");
        System.out.println("🎉 RESERVATION CONFIRMED 🎉");
        System.out.println("================================");

        p.displayPassenger();

        if (g != null)
            g.displayGuardian();

        f.displayFlight();
    }
}