package com.coffee.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coffee.presentation.R

@SuppressLint("ComposeModifierMissing")
@Composable
fun DecoratedButton(text: String, transparent: Boolean = false, onClick: () -> Unit) {
    val font = FontFamily(
        Font(R.font.bold, FontWeight.Bold), Font(R.font.regular, FontWeight.Light)
    )
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(10.dp, 0.dp, 10.dp)
            .fillMaxWidth()
            .height(55.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (transparent) Color.Transparent
            else Color(0xFFCE9760)
        )
    ) {
        Text(
            text = text,
            color = if (transparent)
                Color(0xFFCE9760)
            else
                Color(0xFF543A20),
            fontSize = 22.sp,
            fontFamily = font,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    DecoratedButton(text = "Register") {}
}