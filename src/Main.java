//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.put(1, 2, "КОНСТРУКТОР");
        toyStore.put(2, 2, "РОБОТ");
        toyStore.put(3, 6, "КУКЛА");
        toyStore.out();
        toyStore.simulateAndGetResults();

    }
}