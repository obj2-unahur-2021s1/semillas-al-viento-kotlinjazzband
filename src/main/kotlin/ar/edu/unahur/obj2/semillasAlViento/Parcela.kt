package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {

  val plantas = mutableListOf<Planta>()
  fun cantidadPlantada() = plantas.size
  fun superficie(): Int = ancho * largo
  fun cantidadMaximaDePlantas() = if (ancho > largo) superficie() / 5 else superficie()/ 3 + largo
  fun parcelaTieneComplicaciones() = plantas.any { it.horasDeSolQueTolera() < horasSolPorDia }
  fun cantidadQuePuedoPlantar() = this.cantidadMaximaDePlantas() - this.cantidadPlantada()
  fun quedaLugarEnParcela():Boolean = this.cantidadPlantada() < this.cantidadMaximaDePlantas()
  fun plantaToleraElSolDeLaParcela(planta: Planta):Boolean = horasSolPorDia+2 > planta.horasDeSolQueTolera()
  fun esParcelaSemillera() = plantas.all{ planta -> planta.daSemillas() }
  fun noSeCumplenRequisitosParaPlantar(planta: Planta): Boolean =  quedaLugarEnParcela() && plantaToleraElSolDeLaParcela(planta)
  fun plantar(planta: Planta) {
    if (!this.noSeCumplenRequisitosParaPlantar(planta)) {
      error("No hay lugar en la parcela o la planta no tolera el sol")
    }else{
      plantas.add(planta)
       }
  }
}