package com.coffee.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coffee.presentation.R

@SuppressLint("ComposeViewModelForwarding")
@Composable
fun editText(placeholder: String, isPassword: Boolean = false): TextFieldValue {
    var value = TextFieldValue()
    TextField(
        value = value,
        onValueChange = { value = it },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF16181C),
            focusedPlaceholderColor = Color(0xFF828282),
            focusedIndicatorColor = Color.Transparent,
            unfocusedPlaceholderColor = Color(0xFF828282),
            unfocusedContainerColor = Color(0xFF16181C),
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.regular)),
                fontWeight = FontWeight.W700,
                modifier = Modifier.offset(0.dp, 5.dp)
            )
        },
        modifier = Modifier
            .width(350.dp)
            .height(60.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
    return value
}

@Preview
@Composable
private fun EditTextPreview() {
    editText("E-mail Address", true)
}