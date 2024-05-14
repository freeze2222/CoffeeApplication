package com.coffee.presentation.screens.loginScreen

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.coffee.presentation.R
import com.coffee.presentation.composable.editText

@Composable
fun LoginScreen(navController: NavHostController) {
    LoginScreenContent()
}

@SuppressLint("ComposeModifierMissing")
@Composable
fun LoginScreenContent() {
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
            text = "Welcome to Login",
            fontFamily = FontFamily(Font(R.font.regular)),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        val email = editText(placeholder = "E-mail Address")
        Spacer(modifier = Modifier.height(25.dp))
        val password = editText(placeholder = "Password", isPassword = true)
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier
            .padding(end = 15.dp)
            .fillMaxWidth()) {
            ClickableText(text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontFamily = FontFamily(Font(R.font.bold)),
                        color = Color(0xFFCE9760),
                        fontSize = 12.sp
                    )
                ) {
                    append("Forgot Password?")
                }
            }) {
                //TODO
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Button(onClick = { /*TODO*/ }, ) {
            
        //}
    }
}

@Preview
@Composable
private fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}