public class Car {
    String model;
    int horsepower;

    public Car(String maker, int horsepower) {
        model = maker;
        horsepower = horsepower;
    }
    public Car() {
        model = "";
        horsepower = 0;
    }

    public String getCarmaker() {
        return model;
    }
    public void setCarMaker(String Model) {
        model = Model;
    }
    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int Horsepower) {
        horsepower = Horsepower;
    }

    public static void main(String[] args) {
        Car p = new Car();
        p.setHorsepower(100);
        p.setCarMaker("Honda");
        System.out.println(p.getCarmaker());
        System.out.println(p.getHorsepower());
    }
}
