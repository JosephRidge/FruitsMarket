package com.jayr.fruitsmarket.data.models

import com.jayr.fruitsmarket.R

data class Fruit(
    val name: String,
    val description: String,
    val image: Int,
    val price: Float,
    val quantityAvailable: Float,
    val supplier: String,
)


fun getFruits(): List<Fruit> {
    return listOf(
        Fruit(
            name = "Banana",
            description = "High levels of Potassium",
            image = R.drawable.bananas,
            price = 10.5f,
            quantityAvailable = 20f,
            supplier = "Farm by Morris"
        ),

        Fruit(
            name = "Dragon Fruits",
            description = "High levels of calcium and make you fly",
            image = R.drawable.dragon_fruit,
            price = 50.55f,
            quantityAvailable = 30f,
            supplier = "Farm by Morris"
        ),

        Fruit(
            name = "Grapes",
            description = "Best for making wine",
            image = R.drawable.grapes,
            price = 120.55f,
            quantityAvailable = 30f,
            supplier = "Farm by Morris"
        ),

        Fruit(
            name = "Oranges",
            description = "Best for making orange margarine",
            image = R.drawable.orange,
            price = 120.55f,
            quantityAvailable = 30f,
            supplier = "Farm by Morris"
        ),

        Fruit(
            name = "Pineapples",
            description = "Best for making pineapple juice",
            image = R.drawable.pineapples,
            price = 154.55f,
            quantityAvailable = 50f,
            supplier = "Farm by Morris"
        ),
        Fruit(
            name = "Tangerines",
            description = "Best for making tangerine juice with extra pulps",
            image = R.drawable.tangerine,
            price = 154.55f,
            quantityAvailable = 50f,
            supplier = "Farm by Morris"
        ),
    )
}