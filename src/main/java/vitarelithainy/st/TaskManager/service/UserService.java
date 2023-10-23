package vitarelithainy.st.TaskManager.service;

import vitarelithainy.st.TaskManager.model.Task;
import vitarelithainy.st.TaskManager.model.User;

import java.util.UUID;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
    
}
