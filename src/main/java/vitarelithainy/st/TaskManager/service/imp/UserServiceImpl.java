package vitarelithainy.st.TaskManager.service.imp;

import org.springframework.stereotype.Service;
import vitarelithainy.st.TaskManager.model.Task;
import vitarelithainy.st.TaskManager.repository.UserRepository;
import vitarelithainy.st.TaskManager.model.User;
import vitarelithainy.st.TaskManager.service.UserService;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {

        return userRepository.save(userToCreate);
    }

}
