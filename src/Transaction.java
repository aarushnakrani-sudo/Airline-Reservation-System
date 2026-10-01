/* ================= Transaction Class ================= */
class Transaction {

    static int totalTransactions = 0;
    static double totalAmount = 0;

    int id;
    double amount;

    Transaction(double amt) {

        amount = amt;
        id = ++totalTransactions;
        totalAmount += amount;
    }

    void showTransaction() {

        System.out.println("Transaction ID: " + id);
        System.out.println("Amount Paid: ₹" + amount);
    }

    void showTransaction(String g) {

        System.out.println("\n💳 PAYMENT DETAILS");
        System.out.println("--------------------------------");
        System.out.println("Transaction ID: " + id);
        System.out.println("Amount Paid: ₹" + amount);
        System.out.println("--------------------------------");
    }
}