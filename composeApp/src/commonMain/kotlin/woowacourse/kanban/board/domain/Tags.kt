package woowacourse.kanban.board.domain

import woowacourse.kanban.board.exception.TagError
import woowacourse.kanban.board.exception.TagException

data class Tags(val tags: List<String>) {
    init {
        tags.forEach {
            runCatching { Tag(it) }.onFailure { exception -> throw exception }
        }
        if (tags.size > 5) throw TagException(TagError.TooMany)
    }
}
