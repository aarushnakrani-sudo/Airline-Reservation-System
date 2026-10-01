import java.util.Scanner;

/* ================= Admin Class ================= */
class Admin {

    private String username = "admin";
    private String password = "admin123";

    boolean login(Scanner sc) {

        System.out.println("================================");
        System.out.println("🔐 ADMIN LOGIN");

        System.out.print("Username: ");
        String user = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        if (user.equals(username) && pass.equals(password)) {

            System.out.println("✅ Login successful");
            return true;
        }
        else {

            System.out.println("❌ Invalid credentials");
            return false;
        }
    }
}