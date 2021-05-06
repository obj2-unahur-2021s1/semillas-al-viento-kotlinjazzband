package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()
  var cantidadPlantas = 0 // la variable no es necesaria REDUNDANCIA MINIMA
  // -> debería usarse solo la lista y planta.size para obtener la cantidad

  fun superficie() = ancho * largo

  // Abstracción: deberia utilizar la funcion creada paa tal fin de superficie()
  // y la expresión seria -> return if(ancho > largo) this.superficie()/5 else this.superficie()/3 + largo
  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo


  // COHESION ->
  // método parcelaTieneComplicaciones(): Boolean -> La responsabilidad es expresar si hay complicación
  // faltaría un método(subtarea) plantasDeLaParcela() que retorne el nro de actual de plantados en la parcela.
  // ROBUSTEZ ->
  // método plantar(). chequear si no hay complicaciones  -> si no hay  ->  plantar   si hay (lanzar error)
  // Sencillez: Al no ser necesario el atributo cantidadPlantas, puede utilizarse en su lugar plantas.size en la siguiente funcion
  fun plantar(planta: Planta) {
    if (cantidadPlantas == this.cantidadMaximaPlantas()) {
      println("Ya no hay lugar en esta parcela")
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)
      cantidadPlantas += 1 // no iria. REDUNDANCIA
    }
  }
}

// MUTACIÓN CONTROLADA ListOf -> en lugar de MutableList. No puede haber cambios en la lista
class Agricultora(val parcelas: MutableList<Parcela>) {

  // SIMPLICITY
  var ahorrosEnPesos = 20000 // variable innecesaria
  // Método innecesario, las parcelas no se pueden vender ni comprar. No esta en los requerimientos
  // Suponemos que una parcela vale 5000 pesos
  fun comprarParcela(parcela: Parcela) {
    if (ahorrosEnPesos >= 5000) {
      parcelas.add(parcela)
      ahorrosEnPesos -= 5000
    }
  }

  // Simplicidad: Genera una coleccion de parcelas que cumplen con una condicion de manera clara.
  fun parcelasSemilleras() =
    parcelas.filter { parcela -> parcela.plantas.all { planta -> planta.daSemillas() }   }

  // DESACOPLAMIENTO -> método parcelaElegida() -> responsabilidad de elegir la parcela
  // ROBUSTEZ -> lanzar error si no se puede plantar
  fun plantarEstrategicamente(planta: Planta) {
    val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadPlantas }!!
    laElegida.plantas.add(planta)
  }
}
