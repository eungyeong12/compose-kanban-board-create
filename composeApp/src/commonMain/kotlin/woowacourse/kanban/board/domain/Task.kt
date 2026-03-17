package woowacourse.kanban.board.domain

import woowacourse.kanban.board.exception.TagError

class Task private constructor(
    val title: String,
    val content: String = "",
    val tags: List<Tag> = emptyList(),
    val taskState: TaskState = TaskState.TO_DO,
    val author: String,
) {

    companion object {
        fun isValidTags(tags: List<String>): TagError {
            tags.forEach {
                val result = Tag.isValid(it)
                if (result != TagError.NONE) return result
            }
            if (tags.size > 5) return TagError.TooMany
            return TagError.NONE
        }
    }
}
