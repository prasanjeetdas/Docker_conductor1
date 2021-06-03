package com.example.newDockerFile.DockerFileDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.task.WorkflowTaskCoordinator;
import com.netflix.conductor.client.worker.Worker;
import com.example.newDockerFile.DockerFileDemo.StarterWorker;

@SpringBootApplication
public class DockerFileDemoApplication {



	public static void main(String[] args) {

		SpringApplication.run(DockerFileDemoApplication.class, args);
		Logger logger =
				LoggerFactory.getLogger(DockerFileDemoApplication.class);
		TaskClient taskClient = new TaskClient();

		// The Conductor's API URL
		taskClient.setRootURI("http://localhost:8080/api/");

		// The max. Number of parallel tasks the workers will be executing
		int threadCount = 2;

		// Configuring each Worker to execute all task of the WorkFlow
		Worker starterWorker =
				new StarterWorker("get_starting_params");

		// Create WorkflowTaskCoordinator
		WorkflowTaskCoordinator.Builder builder =
				new WorkflowTaskCoordinator.Builder();
		WorkflowTaskCoordinator coordinator = builder.
				withWorkers( starterWorker ).
				withThreadCount(threadCount).
				withTaskClient(taskClient).build();

		//Start for polling and execution of the tasks
		logger.info("Initiating Worker Manager...");
		coordinator.init();



	}

}
