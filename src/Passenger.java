class Passenger {

    int id;
    String name;
    int age;

    Passenger(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void displayPassenger() {
        System.out.println("👤 Passenger ID: " + id);
        System.out.println("🧾 Passenger Name: " + name);
        System.out.println("🎂 Passenger Age: " + age);
    }

    void displayPassenger(String msg) {
        displayPassenger();
        System.out.println("📝 Note: " + msg);
    }
}