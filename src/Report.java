/* ================= Report Class ================= */
class Report {

    int booked;
    int cancelled;

    Report(int b, int c) {
        booked = b;
        cancelled = c;
    }

    void showReport() {

        System.out.println("\n📊 DAILY REPORT");
        System.out.println("================================");
        System.out.println("✅ Booked Tickets: " + booked);
        System.out.println("❌ Cancelled Tickets: " + cancelled);
        System.out.println("💰 Total Revenue: ₹" + Transaction.totalAmount);
        System.out.println("================================");
    }
}