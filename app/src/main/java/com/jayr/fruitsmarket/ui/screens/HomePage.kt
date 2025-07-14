package com.jayr.fruitsmarket.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jayr.fruitsmarket.ui.components.FruitCardItem
import com.jayr.fruitsmarket.ui.viewmodel.ShopViewModel

@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomePage(innerPadding: PaddingValues, shopViewModel: ShopViewModel = viewModel()) {/*
    * Attain the screen dimensions
    * */
    val configuration = LocalConfiguration.current
    configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        modifier = Modifier.padding(innerPadding),
    ) {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp)
        ) {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Green
                ), onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart, contentDescription = "Image of Cart"
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

                FruitCardItem(item = item, screenWidth = screenWidth, addToCart = {

                    shopViewModel.addToCart(item)

                }, reduceStockQuantity = {
                    shopViewModel.reduceItemFromCart(item = item, index = index)
                })

            }
        }
    }
}
