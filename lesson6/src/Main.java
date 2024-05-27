public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Иван Иваныч","Уборщик","ivan@gmail.com","+79993332222",10000,30);//1
        employee.info();
        System.out.println();


        Employee[] employees = new Employee[5];                                                                                                     //2
        employees[0] = new Employee("Иван Иваныч","Уборщик","ivan@gmail.com","+79993332222",10000,30);
        employees[1] = new Employee("Иван Романыч","Уборщик","Ivan2@gmail.com","+79993132222",10000,30);
        employees[2] = new Employee("Роман Иваныч","Уборщик","Roman@gmail.com","+79993332212",10000,30);
        employees[3] = new Employee("Роман Романыч","Уборщик","RomanR@gmail.com","+71193332222",10000,30);
        employees[4] = new Employee("Джозеппе Карлыч","Главный уборщик","CleanMan@gmail.com","+77777777777",1000000,60);


        for (Employee employee1 : employees) {
            employee1.info();
            System.out.println();
        }
    }
}
