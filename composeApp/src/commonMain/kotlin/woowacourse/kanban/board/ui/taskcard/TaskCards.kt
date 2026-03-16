package woowacourse.kanban.board.ui.taskcard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskCards() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                author = "다이노"
            )
        }
        item {
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                tags = listOf("컴포넌트", "성능"),
                author = "다이노"
            )
        }
        item {
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                author = "다이노"
            )
        }
        item {
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                author = "다이노",
            )
        }
        item {
            TaskCard(
                title = "너무너무 긴 제목은 한 줄까지만 노출되고 말줄임표로 처리합니다",
                content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
                tags = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
                author = "너무너무너무 긴 담당자도 한 줄이지만 노출되고 말줄임표로 처리합니다"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskCardsPreview() {
    TaskCards()
}
