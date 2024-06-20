import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Telephone {
    private Map<String, List<String>> directory;

    public Telephone() {
        // Используем HashMap для хранения данных
        this.directory = new HashMap<>();
    }

    public void add(String surname, String number) {
        // Если фамилия уже есть в справочнике, добавляем номер к списку номеров
        if (directory.containsKey(surname)) {
            directory.get(surname).add(number);
        } else {
            // Если фамилии нет, создаем новый список с одним номером
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            directory.put(surname, numbers);
        }
    }

    public List<String> get(String surname) {
        // Возвращаем список номеров по фамилии или пустой список, если фамилия не найдена
        return directory.getOrDefault(surname, new ArrayList<>());
    }
    public static void main(String[] args) {
        Telephone directory = new Telephone();
        directory.add("Ivanov", "123-456-7890");
        directory.add("Petrov", "234-567-8901");
        directory.add("Ivanov", "345-678-9012");

        System.out.println("Phone numbers for Ivanov: " + directory.get("Ivanov"));
        System.out.println("Phone numbers for Petrov: " + directory.get("Petrov"));
        System.out.println("Phone numbers for Sidorov: " + directory.get("Sidorov"));
    }
}
