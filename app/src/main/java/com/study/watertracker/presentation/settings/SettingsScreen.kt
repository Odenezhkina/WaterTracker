package com.study.watertracker.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.study.watertracker.R
import com.study.watertracker.domain.model.ActivityLevel
import com.study.watertracker.domain.model.Gender
import com.study.watertracker.presentation.ui.composable.Spinner
import com.study.watertracker.ui.theme.*

@Preview
@Composable
fun SettingScreenPreview() {
    SettingsScreen(modifier = Modifier)
}

@Composable
fun SettingsScreen(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
            .padding(Padding.SCREENS.value)
    ) {
        // notifications
        CategoryPreference(title = stringResource(id = R.string.preference_category_notification))
        SwitchPreference(
            title = stringResource(id = R.string.preference_reminder_title),
            summary = stringResource(id = R.string.preference_reminder_summary)
        ) {
            // todo setup reminder
        }

        // user information
        CategoryPreference(title = stringResource(id = R.string.preference_category_user_info))

        val genders = Gender.values().map { stringResource(id = it.titleId) }.toList()
        DropdownPreference(
            title = stringResource(id = R.string.gender),
            entities = genders
        ) {
            /// todo gender change
        }

        val activityLevels = ActivityLevel.values().map { stringResource(id = it.titleId) }.toList()
        DropdownPreference(
            title = stringResource(id = R.string.activity_level),
            entities = activityLevels
        ) {
            // todo activity level change
        }

        NumberEditTextPreference(
            title = stringResource(id = R.string.weight),
            value = 50
        ) {
            // todo text changed
        }

        // user settings
        CategoryPreference(title = stringResource(id = R.string.preference_category_user_settings))
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchPreferencePreview() {
    SwitchPreference(
        title = stringResource(id = R.string.preference_reminder_title),
        summary = stringResource(id = R.string.preference_reminder_summary),
        isChecked = true
    ) {

    }
}

private const val SWITCHER_TRACKED_COLOR_ALPHA = 0.5f

@Composable
fun SwitchPreference(
    title: String,
    summary: String? = null,
    isChecked: Boolean = false,
    onCheckedListener: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Padding.VIEW.value)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = TextFontStyle.H4.fontSize,
                    fontWeight = TextFontStyle.H4.fontWeight
                )
                summary?.let {
                    Text(
                        text = summary,
                        fontWeight = TextFontStyle.H5.fontWeight,
                        fontSize = TextFontStyle.H5.fontSize
                    )
                }
            }
            Switch(
                checked = isChecked,
                enabled = true,
                onCheckedChange = { onCheckedListener(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = AccentBlue,
                    checkedTrackColor = AccentBlue.copy(alpha = SWITCHER_TRACKED_COLOR_ALPHA),
                    uncheckedThumbColor = Grey,
                    uncheckedTrackColor = Grey.copy(alpha = SWITCHER_TRACKED_COLOR_ALPHA)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreferencePreview() {
    CategoryPreference("Notifications")
}


@Composable
fun CategoryPreference(title: String) {
    Text(
        text = title,
        fontSize = TextFontStyle.H4.fontSize,
        fontWeight = FontWeight.Medium,
        color = AccentBlue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(Padding.VIEW.value)
    )
}


@Preview(showBackground = true)
@Composable
fun DropdownPreferencePreview() {
    DropdownPreference(
        title = "DropdownPreference",
        entities = listOf("1", "2", "3"),
    ) {

    }
}

@Composable
fun DropdownPreference(
    title: String,
    entities: List<String>,
    onItemSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Padding.VIEW.value)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                title,
                fontSize = TextFontStyle.H5.fontSize,
                fontWeight = TextFontStyle.H5.fontWeight
            )
            Spinner(itemList = entities, selectedItem = entities[0], onItemSelected = {
                onItemSelected(it)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditTextPreferencePreview() {
    NumberEditTextPreference(title = "Weight", value = 4) {

    }
}

@Composable
fun NumberEditTextPreference(title: String, value: Int, onTextChanged: (Int) -> Unit) {
    OutlinedTextField(
        value = value.toString(),
        singleLine = true,
        onValueChange = { onTextChanged(it.toInt()) },
        label = { Text(text = title) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
