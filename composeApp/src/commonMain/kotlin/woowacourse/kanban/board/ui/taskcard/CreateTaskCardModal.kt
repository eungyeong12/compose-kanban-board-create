package woowacourse.kanban.board.ui.taskcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.Tags
import woowacourse.kanban.board.domain.Title
import woowacourse.kanban.board.exception.TagError
import woowacourse.kanban.board.exception.TagException
import woowacourse.kanban.board.exception.TitleError
import woowacourse.kanban.board.exception.TitleException
import woowacourse.kanban.board.ui.taskcard.components.AuthorSelectField
import woowacourse.kanban.board.ui.taskcard.components.ContentInputField
import woowacourse.kanban.board.ui.taskcard.components.CreateTaskActionButtons
import woowacourse.kanban.board.ui.taskcard.components.CreateTaskHeader
import woowacourse.kanban.board.ui.taskcard.components.TagsInputField
import woowacourse.kanban.board.ui.taskcard.components.TaskStateSelectField
import woowacourse.kanban.board.ui.taskcard.components.TitleInputField
import woowacourse.kanban.board.ui.taskcard.state.State

@Composable
fun CreateTaskCardModal(
    state: State,
    onStateChange: (State) -> Unit,
    authors: List<String>,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CreateTaskHeader(onDismissRequest)
        HorizontalDivider()
        TitleInputField(state.title, state.titleError) {
            onStateChange(state.copy(title = it, titleError = runCatching { Title(it) }.fold(
                onSuccess = { TitleError.NONE },
                onFailure = { e -> if (e is TitleException) e.error else TitleError.NONE }
            )))
        }
        ContentInputField(state.content) { onStateChange(state.copy(content = it)) }
        TagsInputField(state.tags, state.tagError) {
            if (it.isEmpty()) {
                onStateChange(state.copy(tags = it, tagError = TagError.NONE))
            } else {
                onStateChange(state.copy(tags = it, tagError = runCatching { Tags(it) }.fold(
                    onSuccess = { TagError.NONE },
                    onFailure = { e -> if (e is TagException) e.error else TagError.NONE }
                )))
            }
        }
        TaskStateSelectField(state.selectedState) { newTaskState ->
            onStateChange(state.copy(selectedState = newTaskState))
        }
        AuthorSelectField(authors, state.selectedAuthor) { newAuthor ->
            onStateChange(state.copy(selectedAuthor = newAuthor))
        }

        HorizontalDivider()

        CreateTaskActionButtons(state.isNewTaskEnabled) {
            onStateChange(state.copy(titleError = runCatching { Title(state.title) }.fold(
                onSuccess = { TitleError.NONE },
                onFailure = { e -> if (e is TitleException) e.error else TitleError.NONE }
            )))
        }
    }
}

@Preview(widthDp = 672)
@Composable
private fun PreviewCreateTaskCardModal() {
    CreateTaskCardModal(
        state = State(),
        onStateChange = {},
        authors = listOf("다이노", "페임스"),
        onDismissRequest = {},
        onConfirmation = {},
        modifier = Modifier
            .background(Color.White).padding(16.dp),
    )
}
