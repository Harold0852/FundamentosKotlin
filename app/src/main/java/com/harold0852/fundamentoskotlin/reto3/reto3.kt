package com.harold0852.fundamentoskotlin.reto3
import kotlin.random.Random
class reto3{
}
data class AuctionItem(val name: String, val minPrice: Double) {
    var highestBid: Double = minPrice
        private set

    fun placeBid(amount: Double): Boolean {
        if (amount > highestBid) {
            highestBid = amount
            return true
        }
        return false
    }

    fun sellToHighestBidder() {
        println("El artículo '$name' se vende al ofertante con la oferta más alta por \$$highestBid")
    }

    fun sellToAuctionHouse() {
        println("No hubo ofertas para el artículo '$name'. Se vende a la casa de subastas por el precio mínimo de \$$minPrice")
    }
}

fun main() {
    val items = listOf(
        AuctionItem("Cuadro antiguo", 100.0),
        AuctionItem("Reloj de pulsera", 200.0),
        AuctionItem("Libro raro", 50.0)
    )

    val bidders = listOf("Comprador1", "Comprador2", "Comprador3", "Comprador4")

    val random = Random(System.currentTimeMillis())

    for (item in items) {
        println("\nSubasta para el artículo '${item.name}' con precio mínimo de \${items.minPrice}")
        var hasBids = false
        for (bidder in bidders) {
            val bidAmount = random.nextDouble(item.minPrice, 1000.0)
            val placedBid = item.placeBid(bidAmount)
            if (placedBid) {
                hasBids = true
                println("$bidder ha ofertado \$$bidAmount")
            }
        }

        if (hasBids) {
            item.sellToHighestBidder()
        } else {
            item.sellToAuctionHouse()
        }
    }
}
