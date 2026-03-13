package woowacourse.kanban.board.ui.taskcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.Task
import woowacourse.kanban.board.domain.TaskState
import woowacourse.kanban.board.ui.taskcard.components.AuthorSelectField
import woowacourse.kanban.board.ui.taskcard.components.ContentInputField
import woowacourse.kanban.board.ui.taskcard.components.CreateTaskActionButtons
import woowacourse.kanban.board.ui.taskcard.components.CreateTaskHeader
import woowacourse.kanban.board.ui.taskcard.components.TagsInputField
import woowacourse.kanban.board.ui.taskcard.components.TaskStateSelectField
import woowacourse.kanban.board.ui.taskcard.components.TitleInputField

@Composable
fun CreateTaskCardModal(authors: List<String>, modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var isTitleError by remember { mutableStateOf(false) }
    var content by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var isTagsError by remember { mutableStateOf(false) }
    var isTagFormatError by remember { mutableStateOf(false) }
    var selectedState by remember { mutableStateOf(TaskState.TO_DO) }
    var selectedAuthor by remember { mutableStateOf(authors.first()) }
    val isNewTaskEnabled by remember { derivedStateOf { !isTitleError && !isTagsError && !isTagFormatError } }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CreateTaskHeader()
        HorizontalDivider()
        TitleInputField(title, isTitleError) {
            title = it
            isTitleError = !Task.isValidTitle(it)
        }
        ContentInputField(content) { content = it }
        TagsInputField(tags, isTagsError, isTagFormatError) {
            tags = it
            val splitTags = tags.split(",").map { tag -> tag.trim() }
            if (tags.isEmpty()) {
                isTagFormatError = false
                isTagsError = false
            } else {
                isTagFormatError = splitTags.any { tag -> tag.isEmpty() }
                isTagsError = !Task.isValidTags(splitTags)
            }
        }
        TaskStateSelectField(selectedState) { newTaskState ->
            selectedState = newTaskState
        }
        AuthorSelectField(authors, selectedAuthor) { newAuthor ->
            selectedAuthor = newAuthor
        }

        HorizontalDivider()

        CreateTaskActionButtons(isNewTaskEnabled) {
            isTitleError = !Task.isValidTitle(title)
        }
    }
}

@Preview(widthDp = 672)
@Composable
private fun PreviewCreateTaskCardModal() {
    CreateTaskCardModal(
        authors = listOf("다이노", "페임스"),
        modifier = Modifier
            .background(Color.White).padding(16.dp),
    )
}
