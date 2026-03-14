package woowacourse.kanban.board.domain

data class Tag private constructor(val name: String) {

    companion object {
        fun from(name: String): Tag {
            require(isValid(name)) { "태그는 5자 이내로 5개까지만 등록할 수 있습니다." }
            return Tag(name)
        }

        fun isValid(value: String): Boolean = value.isNotBlank() && value.length <= 5
    }
}
