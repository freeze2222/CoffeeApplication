package com.coffee.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.utils.TraceUtils.simpleId
import com.coffee.presentation.R

@SuppressLint("ComposeModifierMissing")
@Composable
fun BitLine(text: String) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp), contentAlignment = Alignment.CenterStart
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                text = text,
                modifier = Modifier.onSizeChanged { size = it },
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.regular)
                ),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 10.sp
            )
        }

        Canvas(modifier = Modifier.fillMaxWidth()) {
            drawLine(
                Color(0xFFDD9854),
                Offset(0F, 0F),
                Offset(screenWidth.toPx() / 2 - (size.width - 50), 0F), 3F
            )
            drawLine(
                Color(0xFFDD9854),
                Offset(screenWidth.toPx() / 2 + (size.width - 50), 0F),
                Offset(screenWidth.toPx(), 0F), 3F
            )
        }
    }
}

@Preview
@Composable
private fun BitLinePreview() {
    BitLine(text = "Or Login with")
}