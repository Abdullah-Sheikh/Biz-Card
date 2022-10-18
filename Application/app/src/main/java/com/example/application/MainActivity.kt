package com.example.application

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.application.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   BizCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun BizCard()
{
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth())
    {

        Card(
             modifier = Modifier
                 .height(390.dp)
                 .width(200.dp)
                 .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = androidx.compose.ui.graphics.Color.White,
            elevation = 4.dp

        ) {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

                ) {
                CreateProfileImage()
                Divider()

                CreateInfo()
                
                Button(onClick = {

                    buttonClickedState.value = !buttonClickedState.value
                    }) {

                    Text(text = "Portfolio",
                         style = MaterialTheme.typography.button)
                    
                }
                if(buttonClickedState.value)
                {
                   Content()
                }
                else
                {
                    Box() {
                        
                    }
                }
            }



        }
    }
}


@Preview
@Composable
fun Content()
{

    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp,color= Color.LightGray)
        ) {
            Porfolio(data = listOf("Project 1", "Project 2" , "Project 3"))

        }


    }
}

@Composable
fun Porfolio(data: List<String>) {
   LazyColumn{
       items(data)
       {
           item ->
           Card(modifier = Modifier
               .padding(13.dp)
               .fillMaxWidth(),
           shape = RectangleShape,
           elevation = 4.dp)
           {

               Row(modifier = Modifier
                   .padding(8.dp)
                   .background(MaterialTheme.colors.surface)
               ) {

                   CreateProfileImage(modifier = Modifier.size(75.dp))
                   Column(modifier = Modifier
                       .padding(7.dp)
                       .align(alignment = Alignment.CenterVertically)) {

                       Text(text = item, fontWeight = FontWeight.Bold)
                       Text(text = "A great project indeed ", style = MaterialTheme.typography.body2)

                   }
               }
           }

       }   }
}




@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {

        Text(
            text = "Abdullah S.",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android programmer",
            modifier = Modifier.padding(3.dp)

        )
        Text(
            text = "@abdullah-Sheikh",
            modifier = Modifier.padding(3.dp)

        )

    }
}

@Composable
private fun CreateProfileImage(modifier:Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)

    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.height(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApplicationTheme {
        BizCard()
    }
}