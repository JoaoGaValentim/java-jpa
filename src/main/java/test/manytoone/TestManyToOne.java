package test.manytoone;

import infra.DAO;
import models.todo.CategoryTask;
import models.todo.Task;

public class TestManyToOne {
	public static void main(String[] args) {
		DAO<Task>  taskDao = new DAO<>(Task.class);		
		Task task = taskDao.fetchOneById(1L);

		System.out.println(task.getName());
		System.out.println(task.getDescription());
		for (CategoryTask categoryTask : task.getCategoryTasks()) {
			System.out.println(categoryTask.getCategory().getName());
		}

		taskDao.close();
	}
}
