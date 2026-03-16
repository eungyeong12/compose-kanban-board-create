package woowacourse.kanban.board.ui.taskcard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.profile_image
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.ui.theme.profileText
import woowacourse.kanban.board.ui.theme.tagBackground
import woowacourse.kanban.board.ui.theme.tagText
import woowacourse.kanban.board.ui.theme.taskCardBorder
import woowacourse.kanban.board.ui.theme.taskCardContent
import woowacourse.kanban.board.ui.theme.taskCardTitle

@Composable
fun TaskCard(title: String, content: String = "", tags: List<String> = listOf(), author: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(1.dp, taskCardBorder),
        modifier = Modifier.width(286.dp),
    ) {
        Column(
            modifier = Modifier.padding(17.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Title(title = title)
            if (content.isNotEmpty()) Content(content = content)
            if (tags.isNotEmpty()) Tags(tags = tags)
            HorizontalDivider(color = taskCardBorder)
            Profile(author = author)
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = taskCardTitle,
        fontSize = 16.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Content(content: String) {
    Text(
        text = content,
        style = MaterialTheme.typography.bodyMedium,
        color = taskCardContent,
        fontSize = 14.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Tags(tags: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.forEach { tag ->
            Box(
                modifier = Modifier
                    .height(24.dp)
                    .background(tagBackground, MaterialTheme.shapes.large)
                    .padding(horizontal = 8.dp),
            ) {
                Text(
                    text = tag,
                    style = MaterialTheme.typography.bodyMedium,
                    color = tagText,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    }
}

@Composable
fun Profile(author: String) {
    Row {
        Image(
            painter = painterResource(Res.drawable.profile_image),
            contentDescription = "Profile Image",
            modifier = Modifier.size(24.dp),
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = author,
            style = MaterialTheme.typography.bodyMedium,
            color = profileText,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
private fun TaskCardPreview() {
    TaskCard(
        title = "LazyColumn 컴포넌트 구현",
        content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        tags = listOf("컴포넌트", "성능"),
        author = "다이노"
    )
}