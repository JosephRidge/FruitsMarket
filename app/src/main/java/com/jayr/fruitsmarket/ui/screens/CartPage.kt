package com.jayr.fruitsmarket.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.jayr.fruitsmarket.ui.viewmodel.ShopViewModel

@Composable
fun CartPage(innerPadding: PaddingValues, shopViewModel: ShopViewModel) {

    /*
    * GOAL:
    * - List down all the items
    * - remove an item from the cart and return to the stock
    * - calculate total amount
    *
    * */

    var cart = shopViewModel.cart

    LazyColumn {
        // get a list of all the item sin shopping cart
    }


}