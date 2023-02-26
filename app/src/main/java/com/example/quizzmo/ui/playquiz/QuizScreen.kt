package com.example.quizzmo.ui.playquiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.ui.homescreen.Bar
import com.example.quizzmo.ui.theme.Typography
import com.example.quizzmo.ui.theme.backgroundCyanBlue
import com.example.quizzmo.ui.theme.backgroundDeeperBlue
import com.example.quizzmo.ui.theme.gothamFontFamily

@Composable
fun QuizScreen() {
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
        ContentQuizScreen(
            modifier = Modifier
                .padding(top = 80.dp)
                .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
                .background(
                    color = MaterialTheme.colors.surface
                )
                .fillMaxSize()
                .padding(20.dp)
        )


    }
}


@Composable
fun ContentQuizScreen(
    modifier: Modifier
) {
    Box(modifier = modifier){
        Bar(modifier = Modifier.align(Alignment.TopCenter))

        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.TopCenter)
        ){

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow{
                items(10){ index->
                    val displayIndex = index+1
                    CircularClickableButton(
                        number = displayIndex.toString(),
                        buttonSize = 35.dp,
                        selected = false ,
                        onClick = {

                        } ,
                        index = displayIndex
                    )
                    
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(
                    color = Color.Gray.copy(alpha = 0.3f)
                )

            )

            Spacer(modifier = Modifier.height(10.dp))

            QuestionItem(
               Question(
                   questionNumber = 1,
                   question = "Who said I am the one who knocks?",
                   options = listOf(
                       "Anindya Ray",
                       "No idea",
                       "Heisenberg",
                       "david mickee"
                   )

               )
            )
        }


        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ){
            OutLineButton(colors = listOf(
                backgroundDeeperBlue,
                backgroundCyanBlue
            ),
                text = "Finish Quiz"
            ){

            }
        }


    }

}

@Composable
fun QuestionItem(
    question: Question
) {

    Column {
        question.question?.let {
            Text(text = it,
                style = Typography.h2,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.onSurface)

        }
        
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn{
            itemsIndexed(question.options!!){ index, item ->
                val optionValue = (65+index).toChar()
                Row(modifier = Modifier.fillMaxWidth(), 
                    verticalAlignment = Alignment.CenterVertically) {

                    CircularClickableButton(
                        number = optionValue.toString(),
                        buttonSize = 40.dp,
                        selected = false,
                        onClick = {} ,
                        index = index
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = item,
                        style = Typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )
                    

                }
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }



}


@OptIn(ExperimentalTextApi::class)
@Composable
fun OutLineButton(
    colors:List<Color>,
    text:String,
    onClick:()->Unit
) {
    
    Box(modifier = Modifier
        .padding(bottom = 20.dp)
        .clip(RoundedCornerShape(4.dp))
        .wrapContentWidth()
        .wrapContentHeight()
        .border(
            width = 2.dp,
            brush = Brush.horizontalGradient(colors),
            shape = RoundedCornerShape(4.dp)
        )
        .padding(horizontal = 50.dp, vertical = 10.dp)
        .clickable { onClick }
    ){
        Text(text = text,
        style = TextStyle(
            fontFamily = gothamFontFamily,
            brush =  Brush.horizontalGradient(
                colors = listOf(
                    backgroundDeeperBlue,
                    backgroundCyanBlue
                ),
            )
        ), fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
    
}

@Composable
fun CircularClickableButton(
    number:String,
    buttonSize: Dp,
    selected:Boolean,
    onClick:(Int)->Unit,
    index:Int,
    selectedColor:List<Color> = listOf(
            backgroundDeeperBlue,
            backgroundCyanBlue
        ),
    disabledColor:List<Color> = listOf(
        Color.Gray.copy(alpha = 0.3f),
        Color.Gray.copy(alpha = 0.3f)
    )
){

    Box(modifier = Modifier
        .clip(RoundedCornerShape(50))
        .size(buttonSize)
        .background(
            brush = Brush.horizontalGradient(
                colors = if (selected) selectedColor else disabledColor
            )
        )
        .clickable {
            onClick(index)
        }
    ){
        Text(
            text = number,
            style = Typography.body1,
            modifier = Modifier.align(Alignment.Center),
            color =  MaterialTheme.colors.surface
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ShowButton() {
    CircularClickableButton(number = "1", buttonSize = 50.dp, selected = false, onClick ={

    } , index = 2 )
}


@Preview(showBackground = true)
@Composable
fun ShowQuizScreen() {
    QuizScreen()
}