public class Park {
    public class Attraction {
        private String attractionName;
        private String workingTime;
        private double price;

        public Attraction(String attractionName, String workingTime, double price) {
            this.attractionName = attractionName;
            this.workingTime = workingTime;
            this.price = price;
        }

        public void infoAttraction() {
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workingTime);
            System.out.println("Стоимость: " + price);
        }
    }
}
