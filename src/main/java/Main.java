import java.util.ArrayList;
import java.util.Scanner;
//пишу этот комментарий до начала работы, сразу скажу без Ии я врят-ли обойдусь, буду использовать Deep Seek там где не хватает моей двух недельной квалификации, но буду это комментировать как и весь код в целом
public class Main {
    public static void main(String[] args) {
        Raсe race = new Raсe();
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3]; // Идею использования массива Car подсмотрел у Ии, изначально я хотел использовать ArrayList, но в нем нет нужды т.к. у нас фиксированные вводные данные и лишний раз с ним возиться не хочу :P
        for (int i = 0; i < cars.length; i++) {
            System.out.println("— Введите название машины №" + (i + 1) + ": ");
            String mark = scanner.nextLine();
            int speed = 0;
            while (true) {
                System.out.print("— Введите скорость машины №" + (i + 1) + ": ");
                speed = scanner.nextInt();
                scanner.nextLine();
                if (speed > 0 && speed < 251) {
                    break;
                } else {
                    System.out.println("— Неправильная скорость");
                }

            }
            cars[i] = new Car(mark, speed);
            race.updateLeader(cars[i]);
        }
        System.out.println("Лидер гонки: '" + race.leader +"'");
    }
}
class Car {
    String mark;
    int speed;
    public Car(String mark, int speed) {
        this.mark = mark;
        this.speed = speed;
    }





}
class Raсe {
    String leader = "";
    int leaderDistance = 0;
    public void updateLeader(Car car) {
        int time = 24;
        int distance = car.speed * time;
        if (distance >leaderDistance ) {
            leader = car.mark;
            leaderDistance = car.speed * time;}

}
    }