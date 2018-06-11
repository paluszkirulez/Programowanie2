package Lesson5.Streams.StreamGenericInterface;

public class Car {
    private int price = 0;

    public Car(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                '}';
    }
}
