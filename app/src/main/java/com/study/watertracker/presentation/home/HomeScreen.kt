package com.study.watertracker.presentation.home


import android.widget.TextClock
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.study.watertracker.R
import com.study.watertracker.ui.theme.*
import com.study.watertracker.util.NotFoundException
import com.study.watertracker.util.UiState
import kotlin.math.roundToInt

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    val viewModel = viewModel<HomeViewModel>()
    val state by viewModel.dayWaterIntake.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is UiState.Loading -> {
                // todo
            }
            is UiState.Error -> {
                val stringRes = when (state.error) {
                    is NotFoundException -> R.string.exception_not_found
                    else -> R.string.exception_unknown_error
                }
                Text(
                    modifier = modifier.padding(24.dp),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = stringRes),
                    color = ErrorRed,
                    fontWeight = TextFontStyle.H3.fontWeight,
                    fontSize = TextFontStyle.H3.fontSize
                )
                Spacer(Modifier.height(16.dp))
                Button(modifier = modifier.background(color = Black),
                    onClick = {
                        viewModel.onEvent(HomeEvent.TryAgain)
                    }) {
                    Text(
                        stringResource(id = R.string.btn_try_again),
                        fontSize = TextFontStyle.H3.fontSize
                    )
                }
            }
            is UiState.Success -> {
                TextClock()
                Spacer(Modifier.height(16.dp))
                // todo
                WaterProgressBar(percentage = 80f, maxNumber = 120)
                Spacer(Modifier.height(32.dp))
                BtnAddWater {
                    viewModel.onEvent(HomeEvent.AddGlassOfWater)
                }
            }
        }
    }
}


@Preview
@Composable
fun TextClock(clockTextSize: Float = TextFontStyle.H3.fontSize.value) {
    val pattern24h = stringResource(id = R.string.text_clock_24h_format)
    val pattern12h = stringResource(id = R.string.text_clock_12h_format)
    AndroidView(
        // on below line we are initializing our text clock.
        factory = { context ->
            TextClock(context).apply {
                format24Hour?.let {
                    this.format24Hour = pattern24h
                }
                format12Hour?.let { this.format12Hour = pattern12h }
                timeZone?.let { this.timeZone = it }

                textSize.let { this.textSize = clockTextSize }
            }
        },
        modifier = Modifier
            .padding(8.dp),
    )
}


@Composable
fun BtnAddWater(onClick: () -> Unit) {
    IconButton(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                shape = CircleShape
            )
            .background(Black, shape = CircleShape)
            .padding(8.dp),
        onClick = { onClick() }) {
        Icon(
            painter = painterResource(id = Icons.ADD.iconRes),
            contentDescription = stringResource(id = R.string.btn_add_water_content_description),
            Modifier.size(48.dp),
            tint = White
        )
    }
}

@Preview
@Composable
fun BtnAddWaterPreview() {
    BtnAddWater {
    }
}

@Composable
fun WaterProgressBar(
    percentage: Float,
    maxNumber: Int,
    color: Color = AccentBlue,
    radius: Dp = 100.dp,
    strokeWidth: Dp = 16.dp,
    animationDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val currPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(animationDuration, animDelay)
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color,
                -90f,
                360 * currPercentage.value,
                false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "${(currPercentage.value * maxNumber).roundToInt()}%",
                color = Black,
                fontSize = TextFontStyle.H1.fontSize,
                fontWeight = TextFontStyle.H1.fontWeight
            )
            Text(
                textAlign = TextAlign.Center,
                text = "900/1200 ml", // todo
                color = Black,
                fontSize = TextFontStyle.H3.fontSize,
                fontWeight = TextFontStyle.H3.fontWeight
            )
        }
    }
}

@Preview
@Composable
fun WaterProgressBarPreview() {
    WaterProgressBar(0.7f, 100)
}


