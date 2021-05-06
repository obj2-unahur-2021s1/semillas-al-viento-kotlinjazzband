package ar.edu.unahur.obj2.semillasAlViento
//El atributo altura deberia tener el nombre mas descriptivo: alturaMetros
abstract class Planta(val anioObtencionSemilla: Int, var altura: Float) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  // Simplicidad: Esta función debería implementarse en la class Parcela. Es mas claro que a Parcela
  // podamos consultarle si existe algun problema ahi. Evitamos además pasar el parametro parcela.
  fun parcelaTieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }

  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean
}

class Menta(anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4
}

// DESACOPLAMIENTO -> UNA CLASE PARA LA Soja y UNA CLASE PARA LA SojaTrangenica
// Simplicidad: Soja y SojaTransgenica creandolas de manera independiente heredando de Plantas mantendria el polimorfismo
// sin complejizarlo.
class Soja(anioObtencionSemilla: Int, altura: Float, val esTransgenica: Boolean) : Planta(anioObtencionSemilla, altura) {

  // el metodo deberia retornar solo la cantidad de horas que tolera la soja
  override fun horasDeSolQueTolera(): Int  {
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }
    // DESACOPLAMIENTO -> PARA SOJA TRANSGÉNICA
    return if (esTransgenica) horasBase * 2 else horasBase
  }

  // Este método NO debe incluir esTransgenica. Solo debe retornar el valor para Soja
  override fun daSemillas(): Boolean  {
    if (this.esTransgenica) { // DESACOPLAMIENTO -> PARA SOJA TRANSGÉNICA
      return false
    }
    return this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  }
}
