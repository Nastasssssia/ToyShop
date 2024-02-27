
/**
 * Класс, представляющий игрушку.
 */
public class Toy {
    int id;
    String name;
    int weight;

    /**
     * Конструктор для создания игрушки с заданными параметрами.
     *
     * @param id     уникальный идентификатор игрушки
     * @param name   название игрушки
     * @param weight вес игрушки
     */

    public Toy(int id, int weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

