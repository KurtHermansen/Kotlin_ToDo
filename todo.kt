data class Task(val name: String, val priority: Int)

fun main() {
    val tasks = mutableListOf<Task>()

    while (true) {
        println("To-Do List Application")
        println("=====================")
        println("1. Add Task")
        println("2. View Tasks")
        println("3. Remove Task")
        println("4. Quit")
        print("Enter your choice: ")

        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                print("Enter the task: ")
                val taskName = readLine()
                print("Enter the task priority (1 - High, 2 - Medium, 3 - Low): ")
                val priority = readLine()?.toIntOrNull()

                if (taskName != null && priority != null) {
                    val task = Task(taskName, priority)
                    tasks.add(task)
                    println("Task added.")
                } else {
                    println("Invalid input. Task not added.")
                }

                println()
            }
            2 -> {
                println("Tasks:")
                if (tasks.isEmpty()) {
                    println("No tasks found.")
                } else {
                    tasks.forEachIndexed { index, task ->
                        println("${index + 1}. ${task.name} - Priority: ${task.priority}")
                    }
                }
                println()
            }
            3 -> {
                if (tasks.isEmpty()) {
                    println("No tasks found.")
                } else {
                    println("Select the task to remove:")
                    tasks.forEachIndexed { index, task ->
                        println("${index + 1}. ${task.name} - Priority: ${task.priority}")
                    }
                    print("Enter the task number: ")
                    val taskNumber = readLine()?.toIntOrNull()
                    if (taskNumber in 1..tasks.size) {
                        val removedTask = tasks.removeAt(taskNumber!! - 1)
                        println("Task '${removedTask.name}' - Priority: ${removedTask.priority} removed.")
                    } else {
                        println("Invalid task number.")
                    }
                }
                println()
            }
            4 -> {
                println("Thank you for using the To-Do List Application!")
                return
            }
            else -> {
                println("Invalid choice. Please try again.")
                println()
            }
        }
    }
}
