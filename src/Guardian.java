/* ================= Guardian Class ================= */
class Guardian extends Passenger {

    String relation;

    Guardian(String name, int age, String relation) {
        super(0, name, age);
        this.relation = relation;
    }

    @Override
    void displayPassenger() {
        System.out.println("🛡️ Guardian Name: " + name);
        System.out.println("🛡️ Guardian Age: " + age);
        System.out.println("🤝 Relation: " + relation);
    }

    void displayGuardian() {
        displayPassenger();
    }
}