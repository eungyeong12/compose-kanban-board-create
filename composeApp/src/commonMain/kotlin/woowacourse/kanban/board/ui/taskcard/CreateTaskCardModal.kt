package woowacourse.kanban.board.ui.taskcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.Task
import woowacourse.kanban.board.domain.Title
import woowacourse.kanban.board.exception.TagError
import woowacourse.kanban.board.exception.TitleError
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
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CreateTaskHeader()
        HorizontalDivider()
        TitleInputField(state.title, state.titleError) {
            onStateChange(state.copy(title = it, titleError = Title.isValid(it)))
        }
        ContentInputField(state.content) { onStateChange(state.copy(content = it)) }
        TagsInputField(state.tags, state.tagError) {
            val splitTags = it.split(",").map { tag -> tag.trim() }
            if (it.isEmpty()) {
                onStateChange(state.copy(tags = it, tagError = TagError.NONE))
            } else {
                onStateChange(state.copy(tags = it, tagError = Task.isValidTags(splitTags)))
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
            onStateChange(state.copy(titleError = Title.isValid(state.title)))
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
        modifier = Modifier
            .background(Color.White).padding(16.dp),
    )
}
