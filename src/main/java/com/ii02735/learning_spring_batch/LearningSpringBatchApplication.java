package com.ii02735.learning_spring_batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@Slf4j
public class LearningSpringBatchApplication {

	@Bean
	public Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("firstStep", jobRepository).tasklet(
				(contribution, chunkContext) -> {
					log.info("Executing firstStep : write any logic that you want");
					return RepeatStatus.FINISHED;
				}, transactionManager).build();
	}

	@Bean
	public Job firstJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobBuilder("firstJob", jobRepository)
				.start(firstStep(jobRepository, transactionManager)).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBatchApplication.class, args);
	}

}
