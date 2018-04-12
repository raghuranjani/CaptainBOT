package hello;

import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends JFrame{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
