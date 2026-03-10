package woowacourse.kanban.board.domain

import woowacourse.kanban.board.exception.TagError

@JvmInline
value class Tag private constructor(val value: String) {

    companion object {
        fun isValid(value: String): TagError {
            return when {
                value.isBlank() -> TagError.InValidFormat
                value.length > 5 -> TagError.TooLong
                else -> TagError.NONE
            }
        }
    }
}
