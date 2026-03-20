package woowacourse.kanban.board.ui.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.ui.taskcard.state.State
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class BoardTest {

    @Test
    fun `새 태스크 생성 버튼을 클릭하면 새 태스크 생성 모달이 노출된다`() = runComposeUiTest {
        // given
        setContent {
            Board(
                authors = listOf("다이노", "페임스"),
                state = State(),
                onStateChange = {},
            )
        }

        // when
        onNodeWithText("새 태스크 생성").performClick()

        // then
        onNodeWithText("태스크 제목을 입력하세요", useUnmergedTree = true).assertExists()
    }

    @Test
    fun `새 태스크 생성 모달의 x 아이콘을 클릭하면 모달이 닫힌다`() = runComposeUiTest {
        // given
        setContent {
            Board(
                authors = listOf("다이노", "페임스"),
                state = State(),
                onStateChange = {},
            )
        }

        // when
        onNodeWithText("새 태스크 생성").performClick()
        onNodeWithContentDescription("닫기").performClick()

        // then
        onNodeWithText("태스크 제목을 입력하세요", useUnmergedTree = true).assertDoesNotExist()
    }
}
