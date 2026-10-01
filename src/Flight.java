/* ================= Flight Class ================= */
class Flight {

    int flightNo;
    String source;
    String destination;
    String timing;
    DepartureDate date;
    int availableSeats;

    Flight(int no, int seats) {
        flightNo = no;
        availableSeats = seats;
    }

    void setDetails(String s, String d, String t, DepartureDate dt) {
        source = s;
        destination = d;
        timing = t;
        date = dt;
    }

    void displayFlight() {

        System.out.println("\n================================");
        System.out.println("✈️ Flight Number: " + flightNo);
        System.out.println("🛫 Route: " + source + " → " + destination);
        System.out.println("⏰ Timing: " + timing);

        if (date != null)
            date.displayDate();

        System.out.println("💺 Available Seats: " + availableSeats);
        System.out.println("================================");
    }
}