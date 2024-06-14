class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            food = 0;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
        }
    }
}