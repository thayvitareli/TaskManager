package vitarelithainy.st.TaskManager.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitarelithainy.st.TaskManager.model.Task;
import vitarelithainy.st.TaskManager.model.User;
import vitarelithainy.st.TaskManager.repository.TaskRepository;
import vitarelithainy.st.TaskManager.repository.UserRepository;
import vitarelithainy.st.TaskManager.service.TaskService;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Task create(Task taskToCreate) {
        var user = userRepository.findById(taskToCreate.getUser().getId());
            user = Optional.of(setUserTask(user.get()));
            System.out.println(user);
            taskToCreate = taskRepository.save(taskToCreate);
            return taskRepository.save(taskToCreate);

    }

    private User setUserTask(User user){
        User userTask = new User();
        userTask.setName(user.getName());
        userTask.setEmail(user.getEmail());
        userTask.setUsername(user.getUsername());
        userTask.setPassword(user.getPassword());

        return userTask;
    }


}
