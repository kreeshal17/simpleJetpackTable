package com.krishal.scaffoldall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.krishal.scaffoldall.ui.theme.ScaffoldallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldallTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                      val navController= rememberNavController()
                    NavHost(navController =navController, startDestination = "kree", builder = {
                       composable("kree")
                       {
                           babi(
                               navController =navController
                           )
                       }
                        composable (Route.fav+"/{name}")
                        {
                            val name=it.arguments?.getString("name")
                            screenB(name?:"no name")
                        }


                    })

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScaffoldallTheme {
        Greeting("Android")
    }
}