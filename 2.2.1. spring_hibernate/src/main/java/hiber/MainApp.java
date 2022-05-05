package hiber;

import hiber.model.Car;
import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        Car car1 = new Car("Volga", 3110);
        Car car2 = new Car("Pegaut", 308);
        Car car3 = new Car("Mersedes", 1500);
        Car car4 = new Car("Lada", 2106);

        User user1 = new User("Kolya", "Nikolaev", "kolya@mail.ru");
        User user2 = new User("Vasya", "Vasilyev", "vasya@mail.ru");
        User user3 = new User("Petya", "Petrov", "petya@mail.ru");
        User user4 = new User("Roma", "Romanov", "roma@mail.ru");

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));

        for(User user : userService.listUsers()) {
            System.out.println(user + " has  " + user.getCar());
        }

        System.out.println(userService.getUserBy("Lada", 2106));


        context.close();
    }
}
