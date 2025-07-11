package com.jayr.fruitsmarket.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jayr.fruitsmarket.data.models.Cart
import com.jayr.fruitsmarket.data.models.Fruit
import com.jayr.fruitsmarket.data.models.getFruits

class ShopViewModel: ViewModel() {
    // properties or observables here =>states
    var cart by mutableStateOf(Cart())
    var fruits by mutableStateOf(getFruits())
    private set

    // functions
    fun addToCart(item: Fruit){
        /*   * What is the data object I am manipulating?
            * What action am I doing to it?
            * Trigger recomposition
          * */
        // triggers the recomposition
        var fruits = cart.fruits.toMutableList()
        fruits.add(item) //action
        cart = cart.copy(fruits = fruits)
    }


    fun reduceItemFromCart(item:Fruit, index:Int){
        /*
                       * What data object are we manipulating
                       * What action are we doing
                       * triggere recomposition
                       * */
        val updatedFruits = fruits.toMutableList()
        if(item.quantityAvailable >0){
            updatedFruits[index] = item.copy(quantityAvailable = item.quantityAvailable-1)
        }
        fruits = updatedFruits
    }
}