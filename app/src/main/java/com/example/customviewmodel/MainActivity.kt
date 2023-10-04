package com.example.customviewmodel

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.customviewmodel.ui.theme.CustomViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(MainActivityViewModel())
            }
        }
    }

@Composable
fun MainScreen(mainActivityViewModel:  MainActivityViewModel?) {

    mainActivityViewModel?.counter?.observeAsState()?.value.let{
        Log.i("MainScreen", "Value got updated: $it")
    }


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center)
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Button(onClick = { mainActivityViewModel?.decreaseCounter?.invoke() })
            {
                Text(text = "Decrement")
            }

            Text(text = "${mainActivityViewModel?.counter?.value}")
            Button(onClick = { mainActivityViewModel?.increaseCounter?.invoke() }) {
                Text(text = "Increment")

            }


        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainScreen(null)

}