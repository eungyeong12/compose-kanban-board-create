package woowacourse.kanban.board.ui.board.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import woowacourse.kanban.board.ui.taskcard.CreateTaskCardModal
import woowacourse.kanban.board.ui.taskcard.state.State

@Composable
fun CreateTaskModalDialog(
    authors: List<String>,
    state: State,
    onStateChange: (State) -> Unit,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = {},
    ) {
        CreateTaskCardModal(
            state = state,
            onStateChange = onStateChange,
            authors = authors,
            onDismissRequest = onDismissRequest,
            onConfirmation = onConfirmation,
            modifier = modifier
                .width(672.dp)
                .background(Color.White)
                .padding(16.dp),
        )
    }
}

@Preview
@Composable
private fun CreateTaskModalDialogPreview() {
    CreateTaskModalDialog(
        authors = listOf("다이노", "페임스"),
        state = State(),
        onStateChange = {},
        onDismissRequest = {},
        onConfirmation = {},
    )
}
