public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.run(560);
        dogBobik.swim(5);

        catMurzik.run(100);
        catMurzik.swim(5);

        Bowl bowl = new Bowl(20);

        Cat[] cats = { catMurzik, catBarsik };

        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 15);
            System.out.println(cat.name + " " + (cat.isFull() ? "сыт." : "голоден."));
        }

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}