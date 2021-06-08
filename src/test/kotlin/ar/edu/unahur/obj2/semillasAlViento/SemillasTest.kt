package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class PlantaTest : DescribeSpec({

    val unaDeMenta = Menta(2005,0.5f)
    val unaDeMentita = Menta(2015,0.1f)

    val unaDeSoja = Soja(2010,0.4f)
    val unaDeSojaM = Soja(2010,0.9f)
    val unaDeSojaA = Soja(2010,1.5f)
    val unaDeSojaTranj = SojaTrangenica(2015, 1.2f)

    describe("Chequeando cosas de planta menta"){
        it("de Menta horas De Sol Que Tolera") {
            unaDeMenta.horasDeSolQueTolera().shouldBe(6.0)
        }
        it("Planta de Menta da Semillas") {
            unaDeMenta.daSemillas().shouldBeTrue()
        }
        // la condición debe ser and no or para que funcione si vale la condicion adicional
        it("Planta de Mentita da Semillas") {
            unaDeMentita.daSemillas().shouldBeFalse()
        }
        it("de Menta es Fuerte") {
            unaDeMenta.esFuerte().shouldBeFalse()
        }
    }
    describe("Chequeando cosas de planta de soja") {
        it("unaDeSoja horas De Sol Que Tolera") {
            unaDeSoja.horasDeSolQueTolera().shouldBe(6.0)
        }
        it("unaDeSojaM horas De Sol Que Tolera") {
            unaDeSojaM.horasDeSolQueTolera().shouldBe(7.0)
        }
        it("unaDeSojaA horas De Sol Que Tolera") {
            unaDeSojaA.horasDeSolQueTolera().shouldBe(9.0)
        }
        // soja da semilla si año de semilla es > 2007 y altura > 1m
        it("unaDeSoja de soja daSemillas") {
            unaDeSoja.daSemillas().shouldBeFalse()
        }
        it("unaDeSojaMde soja daSemillas") {
            unaDeSojaM.daSemillas().shouldBeFalse()
        }
        it("unaDeSojaA de soja daSemillas") {
            unaDeSojaA.daSemillas().shouldBeTrue()
        }
        it("Planta unaDeSoja esFuerte") {
            unaDeSoja.esFuerte().shouldBeFalse()
        }
        it("Soja Trangenica da semillas"){
            unaDeSojaTranj.daSemillas().shouldBeFalse()
        }
        it("Soja trangenica horas de sol que tolera"){
            unaDeSojaTranj.horasDeSolQueTolera().shouldBe(18)
        }
    }
})

class ParcelaTest : DescribeSpec({
    val unaParcela = Parcela(20,1,9)

    val unaDeSoja1 = Soja(2010,1.7f)
    val unaDeSoja2 = Soja(2010,1.8f)
    val unaDeSoja3 = Soja(2010,2.1f)
    val unaDeSoja4 = Soja(2010,1.5f)
    val unaDeMentita = Menta(2015,0.1f)

    unaParcela.plantar(unaDeSoja1)
    unaParcela.plantar(unaDeSoja2)
    unaParcela.plantar(unaDeSoja3)
    unaParcela.plantar(unaDeSoja4)

    describe("Chequeando requerimientos de la Parcela"){
        it("Superficie de la Parcela") {
            unaParcela.superficie().shouldBe(20)
        }
        it("Cantidad Maxima Plantas de la parcela ") {
            unaParcela.cantidadMaximaDePlantas().shouldBe(4)
        }
        it("Cantidad plantada en una parcela"){
            unaParcela.cantidadPlantada().shouldBe(4)
        }
        //El metodo esta en Planta, no en parcela por eso no funciona. DESCOMENTAR CUANDO SE PASA EL METODO A PARCELA
        it("Saber si la parcela tiene complicaciones(any plant tolera menos sol que la parcela") {
           unaParcela.parcelaTieneComplicaciones().shouldBe(false)
        }
        fun Any.shouldThrow() { "No hay lugar en la parcela o la planta no tolera el sol"}
        it("parcela Puede plantar unaDeMentita"){
            unaParcela.plantar(unaDeMentita).shouldThrow()
        }
    }
})

class AgricultoraTest : DescribeSpec({
    val unaDeSoja1 = Soja(2010,2.0f)
    val unaParcela1 = Parcela(20,1,9)
    val unaParcela2 = Parcela(20,1,9)

    val unaAgricultora = Agricultora()
    val unaDeMentita = Menta(2015,0.1f)
    unaAgricultora.agregaraParcela(unaParcela1)
    unaAgricultora.agregaraParcela(unaParcela2)
    unaParcela1.plantar(unaDeSoja1)
    unaParcela1.plantar(unaDeSoja1)
    unaParcela1.plantar(unaDeSoja1)
    unaParcela2.plantar(unaDeMentita)
    unaAgricultora.plantarEstrategicamente(unaDeMentita)

    describe("Pidiendo info de Agricultora"){
        it("Si unaAgricultora es semillera. unaParcela1=soja y unaParcela2=mentita. Falso") {
            unaAgricultora.esSemillera().shouldBe(false)
        }
        it("La parcela elegida es (la que tiene menos plantas)"){
            unaAgricultora.parcelaElegida().shouldBe(unaParcela2)
        }
        it("Agricultora plantar estratégicamente") {
            unaParcela2.cantidadPlantada().shouldBe(2)
        }
    }

})
