package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {

  val plantas = mutableListOf<Planta>()
  fun cantidadPlantada() = plantas.size
  fun superficie() = ancho * largo
  fun cantidadMaximaDePlantas() = if (ancho > largo) superficie() / 5 else superficie()/ 3 + largo
  fun parcelaTieneComplicaciones() = plantas.any { it.horasDeSolQueTolera() < horasSolPorDia }

  fun quedaLugarEnParcela():Boolean = cantidadPlantada() < this.cantidadMaximaDePlantas()
  fun plantaToleraElSolDeLaParcela(planta: Planta):Boolean = horasSolPorDia > planta.horasDeSolQueTolera() + 2
/*  */
  fun plantar(planta: Planta) {
    if (!quedaLugarEnParcela() && !plantaToleraElSolDeLaParcela(planta)) {
      error("No hay lugar en la parcela o la planta no tolera el sol")
    }
    else{ plantas.add(planta) }
  }

}


