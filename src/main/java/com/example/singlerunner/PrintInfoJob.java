package com.example.singlerunner;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author Visweshwar Ganesh
 * @Created 03/06/2024 - 4:50 PM
 */

public class PrintInfoJob implements Job {

   private Environment env;

  public PrintInfoJob(Environment env) {
    this.env = env;
  }

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    // Retrieve the application name and port
    String appName = env.getProperty("spring.application.name", "MyApp");
    String serverPort = env.getProperty("server.port", "8080");

    // Print the application name and port
    System.out.println("Executing Job: Application Name - " + appName + ", Port - " + serverPort);
  }
}
