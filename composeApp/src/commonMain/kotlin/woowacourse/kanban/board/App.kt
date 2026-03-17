package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.taskcard.CreateTaskCardModal
import woowacourse.kanban.board.ui.taskcard.state.State

@Preview(showBackground = true)
@Composable
fun App() {
    val authors = listOf("다이노", "페임스")
    var state by remember { mutableStateOf(State(selectedAuthor = authors.first())) }

    CreateTaskCardModal(
        state = state,
        onStateChange = { state = it },
        authors = listOf("다이노", "페임스"),
        modifier = Modifier
            .width(672.dp)
            .background(Color.White)
            .padding(16.dp),
    )
}
