package woowacourse.kanban.board.domain

data class Tag private constructor(val name: String) {

    companion object {
        fun isValid(value: String): Boolean = value.isNotBlank() && value.length <= 5
    }
}
