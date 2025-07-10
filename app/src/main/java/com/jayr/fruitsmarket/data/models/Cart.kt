package com.jayr.fruitsmarket.data.models

data class Cart(
    var fruits: List<Fruit> = listOf<Fruit>()
)

fun getCart(): List<Fruit>{
    var cart = Cart()
    return cart.fruits
}
//fun addToCart(fruit:Fruit, cart: Cart){
//    cart.fruits.add(fruit)
//}