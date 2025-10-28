package dev.chungjungsoo.gptmobile.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A composable that displays a primary long button.
 *
 * @param modifier The modifier to be applied to the button.
 * @param enabled Whether the button is enabled.
 * @param onClick The action to perform when the button is clicked.
 * @param text The text to display on the button.
 */
@Preview
@Composable
fun PrimaryLongButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    text: String = ""
) {
    Button(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        enabled = enabled
    ) {
        Text(text = text)
    }
}
