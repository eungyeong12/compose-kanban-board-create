package woowacourse.kanban.board.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import woowacourse.kanban.board.exception.TagError
import woowacourse.kanban.board.exception.TitleError

class TaskTest {

    @Test
    fun `제목이 비어 있지 않은 경우 유효성 검사 결과로 NONE을 리턴한다`() {
        // given
        val title = "title"

        // when
        val error = Title.isValid(title)

        // then
        assertThat(error).isEqualTo(TitleError.NONE)
    }

    @Test
    fun `제목이 비어 있거나 공백만 있는 경우 유효성 검사 결과로 BLANK를 리턴한다`() {
        // given
        val title = ""

        // when
        val error = Title.isValid(title)

        // then
        assertThat(error).isEqualTo(TitleError.Blank)
    }

    @Test
    fun `태그가 5개를 초과하지 않는 경우 유효성 검사 결과로 NONE을 리턴한다`() {
        // given
        val tags = listOf("tag1", "tag2", "tag3", "tag4", "tag5")

        // when
        val error = Task.isValidTags(tags)

        // then
        assertThat(error).isEqualTo(TagError.NONE)
    }

    @Test
    fun `태그가 5개 초과인 경우 유효성 검사 결과로 TooMany를 리턴한다`() {
        // given
        val tags = listOf("tag1", "tag2", "tag3", "tag4", "tag5", "tag6")

        // when
        val error = Task.isValidTags(tags)

        // then
        assertThat(error).isEqualTo(TagError.TooMany)
    }
}
