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
import coil3.compose.AsyncImage
import com.jayr.fruitsmarket.data.models.Cart
import com.jayr.fruitsmarket.data.models.getCart
import com.jayr.fruitsmarket.data.models.getFruits

@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomePage(innerPadding: PaddingValues) {
    val configuration = LocalConfiguration.current
    configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    // define the mutable states
    var cart = remember { mutableStateOf(Cart()) }
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
                Text(text = "${cart.value.fruits.size}")
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

        var fruits by remember { mutableStateOf(getFruits()) }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            itemsIndexed(fruits) { index, item ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomCenter,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            AsyncImage(
                                model = item.image,
                                contentDescription = "Image of ${item.name}",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Badge(
                                containerColor = Color.Green, modifier = Modifier.padding(4.dp)
                            ) {
                                Text(
                                    text = "Ksh. ${item.price}/=",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(4.dp)
                                )
                            }

                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxHeight()
                        ) {
                            Text(
                                text = item.name, fontSize = 20.sp, fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = item.description,
                                fontSize = 16.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.width(screenWidth * 2 / 4)
                            )
                            Text(
                                text = "Supplier by ${item.supplier}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                            Text(
                                text = " ${item.quantityAvailable} remaining",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxHeight()
                        ) {

                            IconButton(
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = Color.Green
                                ), onClick = {
                                    /*
                                    * - Create a variable of the fruits that is a mutable list
                                    * - Add the new Item to your cart
                                    * - assign the old value of the cart to the new one in this scenario the copy() triggers an update
                                    * */
                                    var fruits = cart.value.fruits.toMutableList()
                                    fruits.add(item)
                                    cart.value = cart.value.copy(fruits = fruits)
                                }) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Icons of add to cart"
                                )
                            }
                        }
                    }
                }


            }
        }
    }
}
