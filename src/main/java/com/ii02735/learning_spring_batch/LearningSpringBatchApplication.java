package com.ii02735.learning_spring_batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * Annotation nécessaire pour charger les beans nécessaires
 * au bon fonctionnement de Spring Batch
 */
@EnableBatchProcessing
public class LearningSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBatchApplication.class, args);
	}

}
