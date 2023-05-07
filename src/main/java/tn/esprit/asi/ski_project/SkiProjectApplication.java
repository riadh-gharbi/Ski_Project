//Spring will go through all the classes inside this package and scans that area only (same level as this main class)
package tn.esprit.asi.ski_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class SkiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkiProjectApplication.class, args);
    }

}
