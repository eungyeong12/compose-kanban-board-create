package woowacourse.kanban.board.ui.taskcard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.TaskState
import woowacourse.kanban.board.domain.toText
import woowacourse.kanban.board.ui.theme.accountCircle
import woowacourse.kanban.board.ui.theme.authorSelected
import woowacourse.kanban.board.ui.theme.authorText
import woowacourse.kanban.board.ui.theme.buttonBackground
import woowacourse.kanban.board.ui.theme.buttonBorder
import woowacourse.kanban.board.ui.theme.selectedAuthorBackground
import woowacourse.kanban.board.ui.theme.selectedTaskStateBackground
import woowacourse.kanban.board.ui.theme.taskStateSelected
import woowacourse.kanban.board.ui.theme.taskStateText

@Composable
fun TaskStateSelectField(selectedState: TaskState, onStateChanged: (TaskState) -> Unit) {
    LabelText("상태 *")
    TaskStateContent(
        selectedState = selectedState,
        onStateChanged = onStateChanged,
    )
}

@Composable
fun AuthorSelectField(authors: List<String>, selectedAuthor: String, onAuthorSelected: (String) -> Unit) {
    LabelText("담당자 *")
    AuthorsContent(
        selectedAuthor = selectedAuthor,
        onAuthorSelected = onAuthorSelected,
        authors = authors,
    )
}

@Composable
private fun TaskStateContent(selectedState: TaskState, onStateChanged: (TaskState) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TaskState.entries.forEach {
            CustomButton(
                borderColor = if (selectedState == it) taskStateSelected else buttonBorder,
                backgroundColor = if (selectedState == it) selectedTaskStateBackground else buttonBackground,
                onClick = { onStateChanged(it) },
                content = {
                    Text(
                        text = it.toText(),
                        color = if (selectedState == it) taskStateSelected else taskStateText,
                        modifier = Modifier.width(180.dp).padding(vertical = 16.dp),
                        textAlign = TextAlign.Center,
                    )
                },
                modifier = Modifier.semantics { selected = selectedState == it },
            )
        }
    }
}

@Composable
private fun AuthorsContent(
    selectedAuthor: String,
    onAuthorSelected: (String) -> Unit,
    authors: List<String>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        authors.forEach {
            CustomButton(
                borderColor = if (selectedAuthor == it) authorSelected else buttonBorder,
                backgroundColor = if (selectedAuthor == it) selectedAuthorBackground else buttonBackground,
                onClick = { onAuthorSelected(it) },
                content = {
                    Row(
                        modifier = Modifier
                            .width(200.dp)
                            .padding(vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = Modifier.padding(horizontal = 12.dp),
                            imageVector = Icons.Default.AccountCircle,
                            tint = accountCircle,
                            contentDescription = "기본 프로필 이미지",
                        )
                        Text(
                            text = it,
                            color = authorText,
                            textAlign = TextAlign.Center,
                        )
                    }
                },
                modifier = Modifier.semantics { selected = selectedAuthor == it },
            )
        }
    }
}

@Composable
private fun CustomButton(
    borderColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .border(2.dp, borderColor, RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) { onClick() },
    ) {
        content()
    }
}
