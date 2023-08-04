package com.harold0852.fundamentoskotlin.reto2

class reto2 {
}
class Album(private val albumName: String, private val musicType: String) {
    private val songs = mutableListOf<Song>()

    fun addSong(title: String, artist: String, year: Int, playCount: Int) {
        songs.add(Song(title, artist, year, playCount))
    }

    fun getNumberOfSongs(): Int {
        return songs.size
    }

    fun getMostPopularSong(): Song? {
        return songs.maxByOrNull { it.playCount }
    }

    fun printSongDescriptions() {
        for (song in songs) {
            val popularity = if (song.playCount < 1000) "poco popular" else "más popular"
            println("${song.title}, interpretada por ${song.artist}, se lanzó en ${song.year}, ${song.playCount} reproducciones, $popularity del álbum.")
        }
    }

    inner class Song(val title: String, val artist: String, val year: Int, val playCount: Int)
}

fun main() {
    val myAlbum = Album("Mi Álbum", "Rock")

    myAlbum.addSong("Canción 1", "Artista 1", 2000, 750)
    myAlbum.addSong("Canción 2", "Artista 2", 2010, 1200)
    myAlbum.addSong("Canción 3", "Artista 3", 2021, 300)
    myAlbum.addSong("Canción 4", "Artista 4", 1995, 5000)

    println("Número de canciones en el álbum: ${myAlbum.getNumberOfSongs()}")

    val mostPopularSong = myAlbum.getMostPopularSong()
    if (mostPopularSong != null) {
        println("La canción más popular del álbum es: ${mostPopularSong.title}, con ${mostPopularSong.playCount} reproducciones.")
    } else {
        println("El álbum no tiene canciones.")
    }

    println("Descripciones de las canciones en el álbum:")
    myAlbum.printSongDescriptions()
}
