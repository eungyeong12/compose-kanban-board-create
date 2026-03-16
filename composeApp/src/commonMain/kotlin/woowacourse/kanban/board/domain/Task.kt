package woowacourse.kanban.board.domain

class Task private constructor(
    val title: String,
    val content: String = "",
    val tags: List<Tag> = emptyList(),
    val taskState: TaskState = TaskState.TO_DO,
    val author: String,
) {

    companion object {
        fun isValidTitle(value: String): Boolean = value.isNotBlank()

        fun isValidTags(tags: List<String>): Boolean = tags.all { Tag.isValid(it) } && isValidTagCount(tags)

        private fun isValidTagCount(tags: List<String>): Boolean = tags.size <= 5
    }
}
