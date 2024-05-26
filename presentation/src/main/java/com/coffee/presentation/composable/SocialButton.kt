package com.coffee.presentation.composable

import android.annotation.SuppressLint
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coffee.presentation.R

@SuppressLint("ComposeModifierMissing")
@Composable
fun SocialButton(id: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp, 65.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xB3101215)),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = id),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun SocialButtonPreview() {
    SocialButton(id = R.drawable.google_logo) {

    }
}