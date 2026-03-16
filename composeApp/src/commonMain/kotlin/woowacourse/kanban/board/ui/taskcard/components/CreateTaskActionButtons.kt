package woowacourse.kanban.board.ui.taskcard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.theme.cancelButtonContainer
import woowacourse.kanban.board.ui.theme.cancelButtonContent
import woowacourse.kanban.board.ui.theme.createButtonContainer
import woowacourse.kanban.board.ui.theme.createButtonContent
import woowacourse.kanban.board.ui.theme.createButtonDisableContent
import woowacourse.kanban.board.ui.theme.createButtonDisabledContainer

@Composable
fun CreateTaskActionButtons(isNewTaskEnabled: Boolean, onCreateClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = cancelButtonContainer,
                contentColor = cancelButtonContent,
            ),
        ) {
            Text(text = "취소", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            onClick = onCreateClick,
            enabled = isNewTaskEnabled,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = createButtonContainer,
                contentColor = createButtonContent,
                disabledContainerColor = createButtonDisabledContainer,
                disabledContentColor = createButtonDisableContent,
            ),
        ) {
            Text(text = "생성", textAlign = TextAlign.Center)
        }
    }
}
