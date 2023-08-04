package com.harold0852.fundamentoskotlin.reto1

class reto1 {
}

fun main() {
    var notificationCounts = mutableMapOf<String, Int>()

    notificationCounts["WhatsApp"] = 0
    notificationCounts["Correo"] = 0
    notificationCounts["Messenger"] = 0

    println("Ingrese el numero de notificaciones de WhatsApp:")
    notificationCounts["WhatsApp"] = readLine()!!.toInt()
    println("Ingrese el numero de notificaciones de Correo:")
    notificationCounts["Correo"] = readLine()!!.toInt()
    println("Ingrese el numero de notificaciones de Messenger:")
    notificationCounts["Messenger"] = readLine()!!.toInt()

    for ((app, count) in notificationCounts) {
        val message = when {
            count == 0 -> "No existen mensajes disponibles en $app"
            count < 100 -> "Tienes $count notificaciones en $app"
            else -> "Tienes 99+ notificaciones en $app"
        }
        println(message)
    }
}