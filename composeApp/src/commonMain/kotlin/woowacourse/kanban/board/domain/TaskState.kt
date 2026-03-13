package woowacourse.kanban.board.domain

enum class TaskState {
    TO_DO,
    IN_PROGRESS,
    DONE,
}

fun TaskState.toText(): String = when (this) {
    TaskState.TO_DO -> "To Do"
    TaskState.IN_PROGRESS -> "In Progress"
    TaskState.DONE -> "Done"
}