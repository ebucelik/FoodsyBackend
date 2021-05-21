package at.ac.campuswien.fh.foodsy.foodsy_backend;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.Port;

@SpringBootApplication
public class FoodsyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodsyBackendApplication.class, args);
	}
}
