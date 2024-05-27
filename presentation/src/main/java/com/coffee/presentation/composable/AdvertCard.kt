package com.coffee.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.coffee.data.models.AdvertData
import com.coffee.presentation.R

@SuppressLint("ComposeModifierMissing")
@Composable
fun AdvertCard(data: AdvertData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xACCE9760))
    ) {
        Column(modifier = Modifier.padding(start = 10.dp, top = 20.dp, bottom = 20.dp)) {
            Text(
                text = data.title,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.semibold)),
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = data.description,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.regular)),
                fontSize = 12.sp,
                modifier = Modifier.width(250.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        AsyncImage(
            model = data.imageLink,
            contentDescription = null,
            modifier = Modifier.size(130.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
private fun AdvertCardPreview() {
    AdvertCard(data = AdvertData())
}