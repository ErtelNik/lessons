class Animal {
    private static int animalCount = 0;

    public Animal() {
        animalCount++;
    }
    public void run(int distance) {
    }
    public void swim(int distance) {
    }
    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    public String name;

    public Dog(String name) {
        super();
        this.name = name;
        dogCount++;
    }


    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }


    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    public String name;
    private boolean isFull;

    public Cat(String name) {
        super();
        this.name = name;
        this.isFull = false;
        catCount++;
    }


    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }


    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eatFromBowl(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            this.isFull = true;
            System.out.println(name + " покушал.");
        } else {
            System.out.println(name + " не хватает еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}