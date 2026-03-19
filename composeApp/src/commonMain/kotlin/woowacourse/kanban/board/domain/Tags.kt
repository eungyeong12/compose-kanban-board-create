package woowacourse.kanban.board.domain

import woowacourse.kanban.board.exception.TagError
import woowacourse.kanban.board.exception.TagException

@JvmInline
value class Tags(val tags: String) {
    init {
        val splitTags = tags.split(",").map { tag -> tag.trim() }
        splitTags.forEach {
            runCatching { Tag(it) }.onFailure { exception -> throw exception }
        }
        if (splitTags.size > 5) throw TagException(TagError.TOO_MANY)
    }
}
