package models.todo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
	private List<CategoryTask> categoryTasks;
	
	public Task() {
	}

	public Task(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CategoryTask> getCategoryTasks() {
		return categoryTasks;
	}

	public void setCategoryTasks(List<CategoryTask> categoryTasks) {
		this.categoryTasks = categoryTasks;
	}
}
