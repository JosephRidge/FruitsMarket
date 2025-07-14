package com.jayr.fruitsmarket.ui.components

import androidx.annotation.NavigationRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.jayr.fruitsmarket.data.models.Cart
import com.jayr.fruitsmarket.data.models.Fruit

@Composable
fun FruitCardItem(item: Fruit,screenWidth:Dp, addToCart:()->Unit, reduceStockQuantity:()->Unit ){
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
                if(item.quantityAvailable >0){
                    Text(
                        text = " ${item.quantityAvailable} left",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }else{
                    Text(
                        text = " Out of stock!",
                        fontSize = 12.sp,
                        color = Color.Red,
                    )
                }

            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
            ) {

                IconButton(
                    enabled = if(item.quantityAvailable >0){true}else{false},
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Green
                    ), onClick = {
                        addToCart()
                        reduceStockQuantity()
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

 