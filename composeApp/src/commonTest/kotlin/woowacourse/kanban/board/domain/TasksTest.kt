package woowacourse.kanban.board.domain

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class TasksTest {

    @Test
    fun `상태(To-Do, In Progress, Done)별 태스크 개수를 올바르게 반환한다`() {
        // given
        val tasks = Tasks(listOf(
            Task(title = "title1", taskState = TaskState.TO_DO),
            Task(title = "title2", taskState = TaskState.TO_DO),
            Task(title = "title3", taskState = TaskState.IN_PROGRESS),
            Task(title = "title4", taskState = TaskState.DONE),
            Task(title = "title5", taskState = TaskState.DONE),
        ))

        // when
        val toDoCount = tasks.countByState(TaskState.TO_DO)
        val inProgressCount = tasks.countByState(TaskState.IN_PROGRESS)
        val doneCount = tasks.countByState(TaskState.DONE)

        // then
        assertThat(doneCount).isEqualTo(2)
        assertThat(inProgressCount).isEqualTo(1)
        assertThat(toDoCount).isEqualTo(2)
    }
}
