package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, val altura: Float) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10
  abstract fun horasDeSolQueTolera(): Int
  fun daSemillas(): Boolean = this.esFuerte() || condicionAdicional()
  abstract fun condicionAdicional(): Boolean
}

class Menta( anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun condicionAdicional() = altura > 0.4
}

class Soja( anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {

  override fun condicionAdicional(): Boolean = (this.anioObtencionSemilla > 2007 && this.altura > 1)

  override fun horasDeSolQueTolera(): Int {
    var horas: Int = 0
    horas = if (altura < 0.5){ 6 }
    else if (altura < 1.0){ 7 }
    else 9
    return horas
  }
}
/*
    var horas: Int = 0
    if (altura < 0.5){ horas = 6}
    else if (altura < 1.0){ horas = 7 }
    else horas = 9
    return horas

    return when (altura){
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }
*/



// el metodo deberia retornar solo la cantidad de horas que tolera la soja
// DESACOPLAMIENTO -> PARA SOJA TRANSGÉNICA
//return if (esTransgenica) horasBase * 2 else horasBase
//if (this.esTransgenica) { // DESACOPLAMIENTO -> PARA SOJA TRANSGÉNICA
//  return false


// Este método NO debe incluir esTransgenica. Solo debe retornar el valor para Soja
// DESACOPLAMIENTO -> UNA CLASE PARA LA Soja y UNA CLASE PARA LA SojaTrangenica
// Simplicidad: Soja y SojaTransgenica creandolas de manera independiente heredando de Plantas mantendía el polimorfismo
// sin complejizarlo.

// Simplicidad: Esta función debería implementarse en la class Parcela. Es mas claro que a Parcela
// podamos consultarle si existe algun problema ahi. Evitamos además pasar el parametro parcela.
//fun parcelaTieneComplicaciones(parcela: Parcela) =
//parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }



