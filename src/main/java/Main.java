class MavenApp {

    void display() {
        System.out.println("CI/CD");
    }
}

public class Main {
    public static void main(String args[]) {

        MavenApp app = new MavenApp();
        app.display();

        System.out.println("CI/CD executed successfully");
    }
}