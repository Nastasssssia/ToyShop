import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Класс, представляющий магазин игрушек.
 */
public class ToyStore implements ToyManager {
    private PriorityQueue<Toy> toyQueue;
    private int[] idArray;
    private String[] nameArray;
    private int[] weightArray;

    /**
     * Конструктор класса ToyStore.
     * Инициализирует приоритетную очередь для игрушек и массивы для хранения данных.
     */
    public ToyStore() {
        toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.weight, t1.weight));
        idArray = new int[3];
        nameArray = new String[3];
        weightArray = new int[3];
    }

    /**
     * Выводит информацию об игрушках в приоритетной очереди.
     */
    @Override
    public void out() {
        for (Toy toy : toyQueue) {
            System.out.println(toy);
        }
    }

    /**
     * Моделирует получение результатов и записывает их в файл.
     */
    @Override
    public void simulateAndGetResults() {
        StringBuilder resultContent = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int result = get();
            resultContent.append("Result ").append(i + 1).append(": ");

            // Добавим информацию о том, какая именно игрушка выпала
            switch (result) {
                case 1:
                    resultContent.append("конструктор");
                    break;
                case 2:
                    resultContent.append("робот");
                    break;
                case 3:
                    resultContent.append("кукла");
                    break;
            }

            resultContent.append("\n");
        }

        writeResultsToFile("output.txt", resultContent.toString());
    }

    /**
     * Добавляет новую игрушку с указанными параметрами.
     *
     * @param id     уникальный идентификатор игрушки
     * @param weight вес игрушки
     * @param name   название игрушки
     */
    @Override
    public void put(int id, int weight, String name) {
        try {
            if (id >= 1 && id <= 3) {
                String input = id + " " + weight + " " + name;
                // Теперь также записываем значения в массивы
                idArray[id - 1] = id;
                nameArray[id - 1] = name;
                weightArray[id - 1] = weight;

                // Создаем объект Toy и добавляем его в очередь
                Toy toy = new Toy(id, weight, name);
                toyQueue.add(toy);
            } else {
                System.out.println("Invalid input format. Please make sure id is in the range 1-3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please make sure id and weight are valid numbers.");
            e.printStackTrace();
        }
    }

    /**
     * Метод для моделирования случайных результатов.
     *
     * @return случайное число, представляющее игрушку
     */
    private int get() {
        double randomNum = Math.random() * 100;

        if (randomNum <= 20) {
            return 1;
        } else if (randomNum <= 40) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * Записывает результаты в файл.
     *
     * @param fileName имя файла
     * @param content  содержимое для записи
     */
    private void writeResultsToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
