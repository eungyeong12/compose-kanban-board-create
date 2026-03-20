package woowacourse.kanban.board.domain

data class Tasks(val tasks: List<Task>) {
    fun countByState(taskState: TaskState): Int = tasks.count { it.taskState == taskState }
}
