package vitarelithainy.st.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitarelithainy.st.TaskManager.model.Task;


import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
