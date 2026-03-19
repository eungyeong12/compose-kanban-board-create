package woowacourse.kanban.board.domain

import woowacourse.kanban.board.exception.TagError
import woowacourse.kanban.board.exception.TagException

@JvmInline
value class Tag(val value: String) {
    init {
        if (value.isBlank()) throw TagException(TagError.InValidFormat)
        if (value.length > 5) throw TagException(TagError.TooLong)
    }
}
