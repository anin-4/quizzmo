package com.example.quizzmo.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizzmo.ui.theme.Typography
import com.example.quizzmo.ui.theme.backgroundCyanBlue
import com.example.quizzmo.ui.theme.backgroundDeeperBlue
import com.example.quizzmo.R
import com.example.quizzmo.ui.theme.gothamFontFamily

@Composable
fun HomeScreen(
    
) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        backgroundDeeperBlue,
                        backgroundCyanBlue
                    )
                )
            )
            .fillMaxSize()
    ){

        Row(
            modifier = Modifier.align(Alignment.TopEnd)
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_face_24),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 20.dp, end = 20.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(50))
            ) 
        }
        
        Column(modifier = Modifier
            .align(Alignment.TopStart)
            .padding(10.dp)) {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "Hello Anindya",
                style = Typography.h2,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Let's Quizzmo",
                style = Typography.h3,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
            
        }

        
        Content(modifier = Modifier)

    }
    
    
}


@Composable
fun Content(
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .padding(top = 200.dp)
            .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
            .background(
                color = MaterialTheme.colors.surface
            )
            .fillMaxSize()
            .padding(20.dp)

    ){

        Row(
            modifier = Modifier.align(Alignment.TopCenter)
        ){
            Box(modifier = Modifier
                .width(60.dp)
                .height(5.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            backgroundDeeperBlue,
                            backgroundCyanBlue
                        )
                    )
                )

            )
        }

        Column(
           modifier = Modifier
               .padding(top = 10.dp)
               .align(Alignment.TopCenter)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Available Quizzes",
                style = Typography.body1,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray.copy(alpha = 0.9f)
            )
            
            Spacer(modifier = Modifier.height(20.dp))


            QuizItem()

            QuizItem()

            QuizItem()

            GradientButton(
                text = "Start Quiz",
                gradient = Brush.horizontalGradient(
                    listOf(
                        backgroundDeeperBlue,
                        backgroundCyanBlue)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(10.dp))
            )


        }

    }

}

@OptIn(ExperimentalTextApi::class)
@Composable
fun QuizItem(
) {

        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
//                .shadow(4.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .wrapContentHeight()
                .border(
                    2.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            backgroundDeeperBlue,
                            backgroundCyanBlue
                        ),
                    ),
                    RoundedCornerShape(10.dp)
                )
                .padding(6.dp)
        ) {
            Image(
                painter = painterResource(id =R.drawable._4_2_target_free_download_png),
                contentDescription = "",
                Modifier
                    .size(80.dp)
                    .padding(start = 10.dp)
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "History Quiz",
                    style = TextStyle(
                        fontFamily = gothamFontFamily,
                        brush =  Brush.horizontalGradient(
                            colors = listOf(
                                backgroundDeeperBlue,
                                backgroundCyanBlue
                            ),
                        )
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Intermediate", style = Typography.body2)

                    Text(text = "-")

                    Text(text = "10 mins")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Anindya Ray",
                    style = Typography.caption,
                    color = Color.Black.copy(alpha = 0.7f)
                )

            }

        }
}

@Composable
fun GradientButton(
    text: String,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                style = Typography.button,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}







@Preview(showBackground = true)
@Composable
fun ShowHomeScreen() {
    HomeScreen()
}