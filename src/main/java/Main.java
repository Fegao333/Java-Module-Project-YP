import java.util.ArrayList;
import java.util.Scanner;
//пишу этот комментарий до начала работы, сразу скажу без Ии я врят-ли обойдусь, буду использовать Deep Seek там где не хватает моей двух недельной квалификации, но буду это комментировать как и весь код в целом
public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Scanner scanner = new Scanner(System.in); //удалил как оказывается не нужный массив
        for (int i = 0; i < 3; i++) {
            System.out.println("— Введите название машины №" + (i + 1) + ": ");
            String mark = scanner.nextLine();
            int speed = 0;
            boolean isValid = false;//реализовал цикл по вашей рекомендации по другому, теперь это while цикл в котором для выхода используется значение boolean, это подняло и читаемость и безопасность цикла, теперь в нем сложнее накосячить
            while (!isValid) {
                System.out.print("— Введите скорость машины №" + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    final int minSpeed = 0; //вынес значения за цикл if, а в самом цикле оставил только переменные, так же на всякий случай тоже сделал их final что бы нельзя было изменить
                    final int maxSpeed = 250;
                    if (speed > minSpeed && speed <= maxSpeed) {
                        isValid = true;
                    } else {
                        System.out.println("— Неправильная скорость");
                    }
                }  else { System.out.println("— Ошибка! Введите число.");
                    scanner.nextLine();}// добавил проверку на то что пишет пользователь в графу скорости, теперь если писать буквы то он просто выдаст ошибку

                }
                Car currentCar = new Car(mark, speed);
                race.updateLeader(currentCar);
            }
            System.out.println("Лидер гонки: '" + race.leader + "'");
        }
    }

     class Car {
        final String mark;//подкорректировал
        final int speed;

        public Car(String mark, int speed) {
            this.mark = mark;
            this.speed = speed;
        }


    }

     class Race {
        String leader = "";
        int leaderDistance = 0;

        public void updateLeader(Car car) {
            int time = 24;
            int distance = car.speed * time;
            if (distance > leaderDistance) {
                leader = car.mark;
                leaderDistance = car.speed * time;
            }

        }
    }