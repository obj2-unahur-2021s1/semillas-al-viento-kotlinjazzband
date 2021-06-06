package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, val altura: Float) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10
  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean
}

class Menta( anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = esFuerte() || altura > 0.4
}

open class Soja( anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {

  override fun daSemillas(): Boolean = esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  override fun horasDeSolQueTolera(): Int {
    var horas: Int = 0
    horas = if (altura < 0.5){ 6 }
    else if (altura < 1.0){ 7 }
    else 9
    return horas
  }
}

class SojaTrangenica( anioObtencionSemilla: Int, altura: Float ): Soja (anioObtencionSemilla, altura) {
  override fun daSemillas(): Boolean = false
  override fun horasDeSolQueTolera(): Int = super.horasDeSolQueTolera() * 2
}