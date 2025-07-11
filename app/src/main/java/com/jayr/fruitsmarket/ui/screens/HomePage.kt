package com.jayr.fruitsmarket.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.jayr.fruitsmarket.data.models.Cart
import com.jayr.fruitsmarket.data.models.getFruits
import com.jayr.fruitsmarket.ui.components.FruitCardItem
import com.jayr.fruitsmarket.ui.viewmodel.ShopViewModel

@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomePage(innerPadding: PaddingValues) {
    /*
    * Attain the screen dimensions
    * */
    val configuration = LocalConfiguration.current
    configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    // define the mutable states
//    var cart by remember { mutableStateOf(Cart()) }
//    var fruits by remember { mutableStateOf(getFruits()) }

    var shopViewModel: ShopViewModel = viewModel()
    var cart = shopViewModel.cart
    var fruits = shopViewModel.fruits


    Column(
        modifier = Modifier.padding(innerPadding),
        ) {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .align(Alignment.End).padding(8.dp)
        ) {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Green
                    ), onClick = {
                    }) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Image of Cart"
                    )
                }

            Badge {
                Text(text = "${shopViewModel.cart.fruits.size}")
            }
        }
        Text(
            text = "Welcome to Fruit Palace, where fruits meet health",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 4.sp,
            lineHeight = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp)
        )

        Spacer(modifier = Modifier.padding(4.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            itemsIndexed(shopViewModel.fruits) { index, item ->

                FruitCardItem(
                    item = item,
                    screenWidth = screenWidth,
                    addToCart = {

                        shopViewModel.addToCart(item)
                    },
                    reduceStockQuantity = {
                       shopViewModel.reduceItemFromCart(item=item, index =index)
                    }
                )

            }
        }
    }
}
