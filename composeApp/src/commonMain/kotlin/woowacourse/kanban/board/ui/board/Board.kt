package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.board.components.BoardHeader
import woowacourse.kanban.board.ui.board.components.CreateTaskModalDialog
import woowacourse.kanban.board.ui.taskcard.state.State

@Composable
fun Board(
    authors: List<String>,
    state: State,
    onStateChange: (State) -> Unit,
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        BoardHeader(
            onClick = { openDialog.value = true },
            modifier = Modifier.fillMaxWidth()
        )

        if (openDialog.value) {
            CreateTaskModalDialog(
                authors = authors,
                state = state,
                onStateChange = onStateChange,
                onDismissRequest = { openDialog.value = false },
                onConfirmation = { openDialog.value = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardPreview() {
    Board(
        authors = listOf("다이노", "페임스"),
        state = State(),
        onStateChange = {},
        modifier = Modifier.size(width = 1295.dp, height = 909.dp)
    )
}
