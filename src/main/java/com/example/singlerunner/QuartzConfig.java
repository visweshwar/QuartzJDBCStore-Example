package com.example.singlerunner;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Visweshwar Ganesh
 * @Created 03/06/2024 - 4:48 PM
 */
@Configuration
public class QuartzConfig {

  @Bean
  public JobDetail printInfoJobDetail() {
    return JobBuilder.newJob(PrintInfoJob.class)
        .withIdentity("PrintInfoJob")
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger printInfoJobTrigger(JobDetail printInfoJobDetail) {
    return TriggerBuilder.newTrigger()
        .forJob(printInfoJobDetail)
        .withIdentity("PrintInfoJobTrigger")
        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
        .build();
  }


}
