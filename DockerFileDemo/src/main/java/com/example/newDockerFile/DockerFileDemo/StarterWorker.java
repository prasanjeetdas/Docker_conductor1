package com.example.newDockerFile.DockerFileDemo;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import com.netflix.conductor.common.metadata.tasks.TaskResult.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarterWorker implements Worker {

    /** The logger. */
private Logger logger = LoggerFactory.getLogger(StarterWorker.class);

    /** The task definition name, present in the Workflow Definition. */
    private String taskDefName;

    /**
     * Instantiates a new worker.
     *
     * @param taskDefName the task def name
     */
    public StarterWorker(String taskDefName) {
        this.taskDefName = taskDefName;
    }

    /* (non-Javadoc)
     * @see com.netflix.conductor.client.worker.Worker#getTaskDefName()
     */
    @Override
    public String getTaskDefName() {
        return taskDefName;
    }

    /* (non-Javadoc)
     * @see com.netflix.conductor.client.worker.Worker#execute(com.netflix.conductor.common.metadata.tasks.Task)
     */
    @Override
    public TaskResult execute(Task task) {

        logger.info("Executing {}.", taskDefName);

        TaskResult result = new TaskResult(task);

        result.setStatus(Status.COMPLETED);

        // Configuring some flow cases
        if ( "get_starting_params".compareTo( task.getReferenceTaskName() ) == 0 ) {
            processGetStartingParams( task, result );
        }

        return result;

    }

    /**
     * Process get_starting_params.
     *
     * @param task the task called from Conductor
     * @param result the result to return to Conductor
     */
    private void processGetStartingParams(Task task,TaskResult result) {

        String confStarter = (String) task.getInputData().get("start_id") + task.getTaskDefName();

        logger.info("-----\n");
        logger.info("Running task: "+task.getTaskDefName());
        logger.info("Input: ");
        logger.info("Starter Param:   {}", (String) task.getInputData().get("start_id") );
        logger.info("Output: ");
        logger.info("Starter Configuration: {}", confStarter );
        logger.info("-----\n");

        //Register the output of the task
        result.getOutputData().put("conf_starter", confStarter);
    }


}

