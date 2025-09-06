package dev.chungjungsoo.gptmobile.presentation.common

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.chungjungsoo.gptmobile.R
import dev.chungjungsoo.gptmobile.data.dto.Platform

/**
 * A composable that displays a checkbox item for a platform.
 *
 * @param modifier The modifier to be applied to the component.
 * @param platform The platform to display.
 * @param enabled Whether the checkbox is enabled.
 * @param title The title of the checkbox item.
 * @param description The description of the checkbox item.
 * @param onClickEvent The event to be invoked when the checkbox is clicked.
 */
@Composable
fun PlatformCheckBoxItem(
    modifier: Modifier = Modifier,
    platform: Platform,
    enabled: Boolean = true,
    title: String = stringResource(R.string.sample_item_title),
    description: String? = stringResource(R.string.sample_item_description),
    onClickEvent: (Platform) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val rowModifier = if (enabled) {
        modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current
            ) { onClickEvent.invoke(platform) }
            .padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
    } else {
        modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
    }
    val textModifier = Modifier.alpha(if (enabled) 1.0f else 0.38f)

    Row(
        modifier = rowModifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            enabled = enabled,
            checked = platform.selected,
            interactionSource = interactionSource,
            onCheckedChange = { onClickEvent.invoke(platform) }
        )
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = title,
                modifier = textModifier,
                style = MaterialTheme.typography.titleMedium
            )
            description?.let {
                Text(
                    text = it,
                    modifier = textModifier,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
