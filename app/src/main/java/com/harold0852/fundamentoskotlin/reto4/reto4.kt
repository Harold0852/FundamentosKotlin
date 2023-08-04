package com.harold0852.fundamentoskotlin.reto4

class reto4 {
}
class Plato(val codigo: Int, var nombre: String, var descripcion: String, var precio: Double) {
    fun modificar(nombre: String, descripcion: String, precio: Double) {
        this.nombre = nombre
        this.descripcion = descripcion
        this.precio = precio
    }
}

class Menu {
    private val entradas = mutableListOf<Plato>()
    private val platosFuertes = mutableListOf<Plato>()
    private val postres = mutableListOf<Plato>()
    private val bebidas = mutableListOf<Plato>()

    fun agregarEntrada(plato: Plato) {
        entradas.add(plato)
    }

    fun agregarPlatoFuerte(plato: Plato) {
        platosFuertes.add(plato)
    }

    fun agregarPostre(plato: Plato) {
        postres.add(plato)
    }

    fun agregarBebida(plato: Plato) {
        bebidas.add(plato)
    }

    fun mostrarMenu() {
        println("---- Menú del Restaurante ----")
        println("Entradas:")
        entradas.forEach { println("${it.codigo}. ${it.nombre} - ${it.descripcion} - \$${it.precio}") }

        println("\nPlatos Fuertes:")
        platosFuertes.forEach { println("${it.codigo}. ${it.nombre} - ${it.descripcion} - \$${it.precio}") }

        println("\nPostres:")
        postres.forEach { println("${it.codigo}. ${it.nombre} - ${it.descripcion} - \$${it.precio}") }

        println("\nBebidas:")
        bebidas.forEach { println("${it.codigo}. ${it.nombre} - ${it.descripcion} - \$${it.precio}") }
    }

    fun mostrarPlatoPorCodigo(codigo: Int) {
        val plato = buscarPlatoPorCodigo(codigo)
        if (plato != null) {
            println("---- Detalles del Plato ----")
            println("Nombre: ${plato.nombre}")
            println("Descripción: ${plato.descripcion}")
            println("Precio: \$${plato.precio}")
        } else {
            println("Plato no encontrado.")
        }
    }

    private fun buscarPlatoPorCodigo(codigo: Int): Plato? {
        return entradas.find { it.codigo == codigo }
            ?: platosFuertes.find { it.codigo == codigo }
            ?: postres.find { it.codigo == codigo }
            ?: bebidas.find { it.codigo == codigo }
    }

    fun modificarPlato(codigo: Int, nuevoPlato: Plato) {
        var platoExistente = buscarPlatoPorCodigo(codigo)
        if (platoExistente != null) {
            platoExistente.modificar(nuevoPlato.nombre, nuevoPlato.descripcion, nuevoPlato.precio)
            println("Plato modificado con éxito.")
        } else {
            println("Plato no encontrado.")
        }
    }

    fun eliminarPlato(codigo: Int) {
        val plato = buscarPlatoPorCodigo(codigo)
        if (plato != null) {
            if (entradas.remove(plato) || platosFuertes.remove(plato) || postres.remove(plato) || bebidas.remove(plato)) {
                println("Plato eliminado con éxito.")
            }
        } else {
            println("Plato no encontrado.")
        }
    }
}

fun main() {
    val menu = Menu()

    menu.agregarEntrada(Plato(1, "Ensalada César", "Lechuga, croutones, queso parmesano y aderezo.", 8.99))
    menu.agregarPlatoFuerte(Plato(2, "Pasta Alfredo", "Pasta con salsa alfredo y pollo.", 12.99))
    menu.agregarPostre(Plato(3, "Tiramisú", "Pastel italiano de café y mascarpone.", 6.99))
    menu.agregarBebida(Plato(4, "Mojito", "Ron, menta, limón y soda.", 7.99))

    menu.mostrarMenu()

    menu.mostrarPlatoPorCodigo(2)

    menu.modificarPlato(1, Plato(1, "Ensalada Mixta", "Lechuga, tomate, pepino y aderezo.", 7.99))
    menu.mostrarMenu()

    menu.eliminarPlato(3)
    menu.mostrarMenu()
}
