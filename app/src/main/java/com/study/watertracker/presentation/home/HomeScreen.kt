package com.study.watertracker.presentation.home

import android.widget.TextClock
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.study.watertracker.R
import com.study.watertracker.presentation.TextFontStyle
import com.study.watertracker.ui.theme.AccentBlue
import com.study.watertracker.ui.theme.Black
import kotlin.math.roundToInt

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextClock()

        Spacer(Modifier.height(16.dp))

        WaterProgressBar(percentage = 80f, maxNumber = 120)

        Spacer(Modifier.height(32.dp))

        BtnAddWater()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}


@Preview
@Composable
fun TextClock(clockTextSize: Float = 20f) {
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
fun BtnAddWater() {
    IconButton(
        modifier = Modifier
            .background(AccentBlue, shape = CircleShape)
            .padding(8.dp),
        onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = stringResource(id = R.string.btn_add_water_content_description)
        )
    }
}

@Preview
@Composable
fun BtnAddWaterPreview() {
    BtnAddWater()
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
                text = "900/1200 ml",
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


