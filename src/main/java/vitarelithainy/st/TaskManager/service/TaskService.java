package vitarelithainy.st.TaskManager.service;

import vitarelithainy.st.TaskManager.model.Task;

public interface TaskService {

    Task findById(Long id);

    Task create(Task taskToCreate);

}
