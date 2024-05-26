package com.coffee.presentation.screens.registerScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coffee.presentation.R
import com.coffee.presentation.composable.BitLine
import com.coffee.presentation.composable.DecoratedButton
import com.coffee.presentation.composable.SocialButton
import com.coffee.presentation.composable.editText

@SuppressLint("ComposeModifierMissing")
@OptIn(ExperimentalTextApi::class)
@Composable
fun RegisterScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background), contentScale = ContentScale.FillBounds
            )
            .paint(
                painterResource(id = R.drawable.second_shader),
                contentScale = ContentScale.FillBounds
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_small),
            contentDescription = null,
            modifier = Modifier.size(55.dp)
        )
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = "Register your Account",
            fontFamily = FontFamily(Font(R.font.regular)),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        val name = editText(placeholder = "E-mail Address")
        Spacer(modifier = Modifier.height(15.dp))
        val email = editText(placeholder = "Password")
        Spacer(modifier = Modifier.height(15.dp))
        val password = editText(placeholder = "Password", isPassword = true)
        Spacer(modifier = Modifier.height(15.dp))
        val passwordConfirmation = editText(placeholder = "Password", isPassword = true)
        Spacer(modifier = Modifier.height(25.dp))
        DecoratedButton(text = "Register") {
            //TODO View model link
        }
        Spacer(modifier = Modifier.height(15.dp))
        BitLine(text = "Or Register with")
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            SocialButton(id = R.drawable.google_logo) { //TODO Logo
                //TODO View model link
            }
            Spacer(modifier = Modifier.width(25.dp))
            SocialButton(id = R.drawable.google_logo) { //TODO Logo
                //TODO View model link
            }
            Spacer(modifier = Modifier.width(25.dp))
            SocialButton(id = R.drawable.google_logo) { //TODO Logo
                //TODO View model link
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.weight(2f)) {
            ClickableText(text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.regular)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Already have an account ? ")
                    withAnnotation("LoginTag", "LoginTag") {
                        withStyle(
                            SpanStyle(
                                color = Color(0xFFCE9760),
                                fontFamily = FontFamily(Font(R.font.bold))
                            )
                        ) {
                            append("Login")
                        }
                    }
                }
            }) {
                //TODO Navigation
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen()
}