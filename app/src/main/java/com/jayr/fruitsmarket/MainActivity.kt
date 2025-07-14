package com.jayr.fruitsmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jayr.fruitsmarket.ui.screens.CartPage
import com.jayr.fruitsmarket.ui.screens.HomePage
import com.jayr.fruitsmarket.ui.theme.FruitsMarketTheme
import com.jayr.fruitsmarket.ui.viewmodel.ShopViewModel

//UI controller: Activity, Fragments, Composables ==> lifecycle
// viewmodels: lifecylce aware
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FruitsMarketTheme {
                Scaffold(
                    topBar = {
                   },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var shopViewModel: ShopViewModel = viewModel()
                    HomePage(innerPadding, shopViewModel)
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
    FruitsMarketTheme {
        Greeting("Android")
    }
}