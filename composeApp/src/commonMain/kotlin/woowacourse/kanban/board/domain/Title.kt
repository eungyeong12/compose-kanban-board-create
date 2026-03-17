package woowacourse.kanban.board.domain

import woowacourse.kanban.board.exception.TitleError

@JvmInline
value class Title private constructor(val value: String) {

    companion object {
        fun isValid(title: String): TitleError {
            if (title.isBlank()) return TitleError.Blank
            return TitleError.NONE
        }
    }
}
