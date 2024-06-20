import java.util.HashMap;
import java.util.Map;

public class UniqueNames {
    public static void main(String[] args) {
        // Создаем массив имен с повторяющимися элементами
        String[] names = {"Алексей", "Мария", "Алексей", "Иван", "Мария", "Сергей", "Алексей", "Екатерина", "Иван", "Алексей", "Екатерина", "Наталья", "Дмитрий", "Дмитрий", "Сергей"};
        
        // Используем HashMap для подсчета частоты каждого имени
        Map<String, Integer> nameCount = new HashMap<>();
        
        for (String name : names) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        
        // Получаем список уникальных имен и их частоту
        System.out.println("Уникальные имена: " + nameCount.keySet());
        System.out.println("Частота имен: " + nameCount);
    }
}
