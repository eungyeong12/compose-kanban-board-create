package woowacourse.kanban.board.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import woowacourse.kanban.board.exception.TagError

class TagTest {

    @Test
    fun `태그 내용이 비어 있지 않고 5자 이하인 경우 유효성 검사 결과로 NONE을 리턴한다`() {
        // given
        val tag = "tag"

        // when
        val error = Tag.isValid(tag)

        // then
        assertThat(error).isEqualTo(TagError.NONE)
    }

    @Test
    fun `태그 내용이 비어 있는 경우 유효성 검사 결과로 InValidFormat을 리턴한다`() {
        // given
        val tag = ""

        // when
        val error = Tag.isValid(tag)

        // then
        assertThat(error).isEqualTo(TagError.InValidFormat)
    }

    @Test
    fun `태그의 길이가 5자를 초과할 경우 유효성 검사 결과로 TooLong을 리턴한다`() {
        // given
        val tag = "123456"

        // when
        val error = Tag.isValid(tag)

        // then
        assertThat(error).isEqualTo(TagError.TooLong)
    }
}
