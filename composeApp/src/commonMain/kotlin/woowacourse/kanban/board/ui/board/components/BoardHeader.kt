package woowacourse.kanban.board.ui.board.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoardHeader(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Compose Desktop 칸반 보드",
                fontWeight = FontWeight.W500,
                fontSize = 24.sp
            )
        }
        Button(
            onClick = onClick
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "새 태스크 생성",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "새 태스크 생성",
                fontWeight = FontWeight.W400,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
private fun BoardHeaderPreview() {
    BoardHeader(onClick = {})
}
