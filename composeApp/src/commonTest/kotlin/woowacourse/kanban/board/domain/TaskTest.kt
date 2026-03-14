package woowacourse.kanban.board.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class TaskTest {

    @Test
    fun `제목이 비어 있지 않은 경우 유효성 검사 결과로 true를 리턴한다`() {
        // given
        val title = "title"

        // when
        val isValid = Task.isValidTitle(title)

        // then
        assertThat(isValid).isTrue()
    }

    @Test
    fun `제목이 비어 있거나 공백만 있는 경우 유효성 검사 결과로 false를 리턴한다`() {
        // given
        val title = ""

        // when
        val isValid = Task.isValidTitle(title)

        // then
        assertThat(isValid).isFalse()
    }

    @Test
    fun `태그가 5개를 초과하지 않는 경우 유효성 검사 결과로 true를 리턴한다`() {
        // given
        val tags = listOf("tag1", "tag2", "tag3", "tag4", "tag5")

        // when
        val isValid = Task.isValidTags(tags)

        // then
        assertThat(isValid).isTrue()
    }

    @Test
    fun `태그가 5개 초과인 경우 유효성 검사 결과로 false를 리턴한다`() {
        // given
        val tags = listOf("tag1", "tag2", "tag3", "tag4", "tag5", "tag6")

        // when
        val isValid = Task.isValidTags(tags)

        // then
        assertThat(isValid).isFalse()
    }
}
