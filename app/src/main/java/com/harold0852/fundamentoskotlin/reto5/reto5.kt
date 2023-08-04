package com.harold0852.fundamentoskotlin.reto5
import kotlin.random.Random

class reto5 {
}

data class User(val phoneNumber: String, val password: String)

class Nequi(private val user: User) {
    private var saldoDisponible: Double = 4500.0

    fun ingresar() {
        println("¡Bienvenido a Nequi!")
        for (i in 1..4) {
            print("Ingrese su número de celular: ")
            val phoneNumberInput = readLine()?.trim() ?: ""
            print("Ingrese su clave de 4 dígitos: ")
            val passwordInput = readLine()?.trim() ?: ""
            if (phoneNumberInput == user.phoneNumber && passwordInput == user.password) {
                println("Acceso concedido.")
                mostrarSaldo()
                mostrarOpciones()
                return
            } else {
                println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes ${4 - i} intentos más.")
            }
        }
        println("Has agotado tus intentos. Hasta pronto.")
    }

    private fun mostrarSaldo() {
        println("Saldo Disponible: \$${saldoDisponible}")
    }

    private fun mostrarOpciones() {
        while (true) {
            println("\n¿Qué deseas hacer?")
            println("1. Saca")
            println("2. Envía")
            println("3. Recarga")
            println("4. Salir")
            print("Opción: ")
            val opcion = readLine()?.toIntOrNull() ?: 0

            when (opcion) {
                1 -> saca()
                2 -> envia()
                3 -> recarga()
                4 -> {
                    println("Hasta pronto.")
                    return
                }
                else -> println("Opción no válida.")
            }
        }
    }

    private fun saca() {
        println("¿Dónde deseas sacar?")
        println("1. Cajero")
        println("2. Punto físico")
        print("Opción: ")
        val opcion = readLine()?.toIntOrNull() ?: 0

        if (saldoDisponible < 2000) {
            println("No te alcanza para hacer el retiro.")
            return
        }

        when (opcion) {
            1, 2 -> {
                print("Ingresa el monto a retirar: ")
                val monto = readLine()?.toDoubleOrNull() ?: 0.0

                if (monto <= saldoDisponible) {
                    saldoDisponible -= monto
                    val codigoRetiro = Random.nextInt(100000, 999999)
                    println("Retiro exitoso. Código de retiro: $codigoRetiro")
                    mostrarSaldo()
                } else {
                    println("No tienes suficiente saldo para hacer el retiro.")
                }
            }
            else -> println("Opción no válida.")
        }
    }

    private fun envia() {
        print("Ingresa el número de teléfono al que deseas enviar dinero: ")
        val phoneNumber = readLine()?.trim() ?: ""
        print("Ingresa el valor a enviar: ")
        val monto = readLine()?.toDoubleOrNull() ?: 0.0

        if (monto <= saldoDisponible) {
            saldoDisponible -= monto
            println("Se ha enviado \$${monto} a $phoneNumber.")
            mostrarSaldo()
        } else {
            println("No tienes suficiente saldo para enviar ese valor.")
        }
    }

    private fun recarga() {
        print("Ingresa el valor a recargar: ")
        val monto = readLine()?.toDoubleOrNull() ?: 0.0
        print("¿Deseas realizar la recarga? (S/N): ")
        val confirmacion = readLine()?.trim()?.uppercase() ?: ""

        if (confirmacion == "S") {
            saldoDisponible += monto
            println("Recarga exitosa.")
            mostrarSaldo()
        } else {
            println("Recarga cancelada.")
        }
    }
}

fun main() {
    val user = User("3009762656", "1234")
    val nequi = Nequi(user)
    nequi.ingresar()
}
