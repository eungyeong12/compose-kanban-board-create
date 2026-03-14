package woowacourse.kanban.board.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TagTest {

    @Test
    fun `태그 내용이 비어 있지 않고 5자 이하인 경우 유효성 검사 결과로 true를 리턴한다`() {
        // given
        val tag = "tag"

        // when
        val isValid = Tag.isValid(tag)

        // then
        assertThat(isValid).isTrue()
    }

    @Test
    fun `태그 내용이 비어 있는 경우 유효성 검사 결과로 false를 리턴한다`() {
        // given
        val tag = ""

        // when
        val isValid = Tag.isValid(tag)

        // then
        assertThat(isValid).isFalse()
    }

    @Test
    fun `태그의 길이가 5자를 초과할 경우 유효성 검사 결과로 false를 리턴한다`() {
        // given
        val tag = "123456"

        // when
        val isValid = Tag.isValid(tag)

        // then
        assertThat(isValid).isFalse()
    }
}
