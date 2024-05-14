package com.coffee.presentation.screens.onBoardingScreen

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.coffee.data.utils.Constants
import com.coffee.presentation.composable.WormPageIndicator
import com.coffee.presentation.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@SuppressLint("ComposeModifierMissing", "DiscouragedApi")
@Composable
fun OnBoardingWelcomeScreen(navController: NavHostController) {
    val data = Constants.OnboardingData[0]
    val context = LocalContext.current
    val font = FontFamily(
        Font(R.font.bold, FontWeight.Bold), Font(R.font.regular, FontWeight.Light)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(
                    id = context.resources.getIdentifier(
                        data.imgId, "drawable", context.packageName
                    )
                ), contentScale = ContentScale.FillBounds
            )
            .paint(
                painterResource(id = R.drawable.shader), contentScale = ContentScale.FillBounds
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        data.title?.let { it1 ->
            Text(
                text = it1,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = font,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        data.desc?.let { it2 ->
            Text(
                text = it2,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = font,
                color = Color(0xFFCE9760),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
        }
        if (data.title == null) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(210.dp)
                    .height(160.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate(Constants.NavDestinations.ONBOARDING_PAGER) },
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 55.dp)
                    .width(245.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCE9760))
            ) {
                Text(
                    text = "Get Started",
                    color = Color(0xFF543A20),
                    fontSize = 22.sp,
                    fontFamily = font,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("ComposeModifierMissing", "DiscouragedApi")
@Composable
fun OnBoardingPagerScreen(navController: NavHostController) {
    val state = rememberPagerState(initialPage = 0, pageCount = { 3 })
    val context = LocalContext.current
    val data = Constants.OnboardingData[state.currentPage + 1]
    val font = FontFamily(
        Font(R.font.bold, FontWeight.Bold), Font(R.font.regular, FontWeight.Light)
    )
    val scope = rememberCoroutineScope()
    HorizontalPager(state = state, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(
                        id = context.resources.getIdentifier(
                            data.imgId, "drawable", context.packageName
                        )
                    ), contentScale = ContentScale.FillBounds
                )
                .paint(
                    painterResource(id = R.drawable.shader), contentScale = ContentScale.FillBounds
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .padding(15.dp, 5.dp, 15.dp, 0.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                WormPageIndicator(totalPages = state.pageCount, currentPage = state.currentPage)


                Spacer(modifier = Modifier.weight(1f))
                if (state.currentPage != state.pageCount - 1) {
                    ClickableText(text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                color = Color.White, fontFamily = font, fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Skip")
                        }
                    }) {
                        scope.launch {
                            state.animateScrollToPage(state.pageCount - 1)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(200.dp))
            data.title?.let { it1 ->
                Text(
                    text = it1,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = font,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            data.desc?.let { it2 ->
                Text(
                    text = it2,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = font,
                    color = Color(0xFFCE9760),
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp
                )
            }
            if (state.currentPage == state.pageCount - 1) {
                Spacer(modifier = Modifier.height(250.dp))
                Button(
                    onClick = { navController.navigate(Constants.NavDestinations.REGISTER) },
                    modifier = Modifier
                        .padding(10.dp, 0.dp, 10.dp)
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCE9760))
                ) {
                    Text(
                        text = "Register",
                        color = Color(0xFF543A20),
                        fontSize = 22.sp,
                        fontFamily = font,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { navController.navigate(Constants.NavDestinations.LOGIN) },
                    modifier = Modifier
                        .padding(10.dp, 0.dp, 10.dp, 55.dp)
                        .fillMaxWidth()
                        .height(55.dp)
                        .border(
                            width = 3.dp,
                            color = Color(0xFFCE9760),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(
                        text = "Sign In",
                        color = Color(0xFFCE9760),
                        fontSize = 22.sp,
                        fontFamily = font,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun OnBoardingPreview() {
    OnBoardingWelcomeScreen(rememberNavController())
}