fun main() {
    val reproductor=ReproductorMidi("pugnodollari.mid")
    var lista = listOf("Perro", "Gato", "Hamster", "Canario", "Cobaya", "Caballo", "Pez", "conejo")
    var palabra = lista.random().lowercase()
    var adivinar = "*".repeat(palabra.length).toMutableList()
    var error = 0
    var dibujo=0
    Thread.sleep(2000)
    println("Bienvenido tienes que adivinar la siguiente palabra ${adivinar.joinToString("")}")
    while (error !== 7) {
        print("Escribe una letra: ")
        var letra = readln().lowercase()
        if (palabra.contains(letra)) {
            for (i in palabra.indices) {
                if (palabra[i] == letra[0]) {
                    adivinar[i] = letra[0]
                }
            }
            println("Palabra actual: ${adivinar.joinToString("")}")
            if (adivinar.joinToString("") == palabra) {
                println("¡Felicidades! Has adivinado la palabra")
                return
            }
        } else {
            dibujo++
            error++
            DibujoAhorcado.dibujar(dibujo)
            println("Palabra actual: ${adivinar.joinToString("")}")
        }
        var intentos = 7 - error
        println("Tienes $intentos errores restantes")
    }
    println("Perdiste, la palabra era: $palabra")
}
