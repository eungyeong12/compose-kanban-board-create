package woowacourse.kanban.board.domain

class Tag private constructor(val name: String) {

    companion object {
        fun isValid(value: String): Boolean = value.isNotBlank() && value.length <= 5
    }
}
