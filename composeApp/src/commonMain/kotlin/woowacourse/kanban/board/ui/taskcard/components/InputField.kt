package woowacourse.kanban.board.ui.taskcard.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ui.theme.infoText
import woowacourse.kanban.board.ui.theme.inputFieldBorder
import woowacourse.kanban.board.ui.theme.inputFieldError
import woowacourse.kanban.board.ui.theme.textFieldBorder
import woowacourse.kanban.board.ui.theme.textFieldDisabledContainer
import woowacourse.kanban.board.ui.theme.textFieldFocusedContainer
import woowacourse.kanban.board.ui.theme.textFieldFocusedIndicator
import woowacourse.kanban.board.ui.theme.textFieldPlaceholder
import woowacourse.kanban.board.ui.theme.textFieldUnfocusedContainer
import woowacourse.kanban.board.ui.theme.textFieldUnfocusedIndicator

@Composable
fun TitleInputField(title: String, isTitleError: Boolean, onValueChange: (String) -> Unit) {
    LabelText("제목 *")
    TextInputField(
        value = title,
        onValueChange = onValueChange,
        placeholder = "태스크 제목을 입력하세요",
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        borderColor = if (isTitleError) inputFieldError else inputFieldBorder,
        isError = isTitleError,
        infoContent = "제목을 입력해주세요.",
        infoTextColor = inputFieldError,
    )
}

@Composable
fun ContentInputField(content: String, onValueChange: (String) -> Unit) {
    LabelText("설명")
    TextInputField(
        value = content,
        onValueChange = onValueChange,
        borderColor = textFieldBorder,
        placeholder = "태스크에 대한 자세한 설명을 입력하세요",
        singleLine = false,
        modifier = Modifier.heightIn(min = 144.dp),
    )
}

@Composable
fun TagsInputField(tags: String, isTagsError: Boolean, isTagFormatError: Boolean, onValueChange: (String) -> Unit) {
    val isError = isTagsError || isTagFormatError
    LabelText("태그")
    TextInputField(
        value = tags,
        onValueChange = onValueChange,
        placeholder = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
        singleLine = true,
        borderColor = if (isError) inputFieldError else inputFieldBorder,
        modifier = Modifier.fillMaxWidth(),
        isError = isError,
        infoContent = when {
            isTagFormatError -> "태그 형식이 올바르지 않습니다."
            isTagsError -> "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
            else -> "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."
        },
        infoTextColor = if (isError) inputFieldError else infoText,
    )
}

@Composable
private fun TextInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    singleLine: Boolean,
    borderColor: Color,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    infoContent: String = "",
    infoTextColor: Color = infoText,
) {
    Column(modifier = modifier) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .border(1.dp, borderColor, RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = textFieldFocusedContainer,
                unfocusedContainerColor = textFieldUnfocusedContainer,
                disabledContainerColor = textFieldDisabledContainer,
                focusedIndicatorColor = textFieldFocusedIndicator,
                unfocusedIndicatorColor = textFieldUnfocusedIndicator,
            ),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = textFieldPlaceholder,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                )
            },
            singleLine = singleLine,
            trailingIcon = {
                if (isError) Icon(
                    Icons.Default.Error,
                    tint = inputFieldError,
                    contentDescription = "경고",
                )
            },
        )
        if (isError) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                text = infoContent,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                color = infoTextColor,
            )
        }
    }
}
