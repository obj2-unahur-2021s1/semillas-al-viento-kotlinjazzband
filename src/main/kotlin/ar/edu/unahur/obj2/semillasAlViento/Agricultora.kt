package ar.edu.unahur.obj2.semillasAlViento

class Agricultora() {
    val parcelas = mutableListOf<Parcela>()
    fun agregaraParcela(parcela: Parcela) = parcelas.add(parcela)
    fun esSemillera() = parcelas.all { parcela -> parcela.esParcelaSemillera() }
    fun parcelaElegida() = parcelas.maxByOrNull { it.cantidadQuePuedoPlantar() }
    fun plantarEstrategicamente(planta: Planta){ this.parcelaElegida()?.plantar(planta) }
}
