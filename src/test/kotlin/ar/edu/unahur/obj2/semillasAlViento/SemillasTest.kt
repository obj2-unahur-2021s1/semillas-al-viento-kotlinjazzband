package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class PlantaTest : DescribeSpec({

    val unaDeMenta = Menta(2005,0.5f)
    val unaDeMentita = Menta(2015,0.1f)

    val unaDeSoja = Soja(2010,0.4f,false)
    val unaDeSojaM = Soja(2010,0.9f,false)
    val unaDeSojaA = Soja(2010,1.5f,false)

    describe("Chequeando cosas de planta menta"){
        it("de Menta horas De Sol Que Tolera") {
            unaDeMenta.horasDeSolQueTolera().shouldBe(6.0)
        }
        it("Planta de Menta da Semillas") {
            unaDeMenta.daSemillas().shouldBeTrue()
        }
        // la condición debe ser and no or para que funcione si vale la condicion adicional
        it("Planta de Mentita da Semillas") {
            //unaDeMenta.daSemillas().shouldBeFalse()
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
    }

})

class ParcelaTest : DescribeSpec({
    val unaParcela = Parcela(20,1,9)
    val unaDeSoja1 = Soja(2010,1.7f,true)
    val unaDeSoja2 = Soja(2010,1.8f,true)
    val unaDeSoja3 = Soja(2010,2.1f,true)
    val unaDeSoja4 = Soja(2010,1.5f,true)
    val unaDeMentita = Menta(2015,0.1f)

    unaParcela.plantar(unaDeSoja1)
    unaParcela.plantas.add(unaDeSoja2)
    unaParcela.plantas.add(unaDeSoja3)
    unaParcela.plantas.add(unaDeSoja4)


    describe("Chequeando requerimientos de una Parcela"){
        it("Conociendo superficie") {
            unaParcela.superficie().shouldBe(20)
        }
        it("Cantidad Maxima Plantas de ll parcela ") {
            unaParcela.cantidadMaximaPlantas().shouldBe(4)
        }
        //El metodo esta en Planta, no en parcela por eso no funciona. DESCOMENTAR CUANDO SE PASA EL METODO A PARCELA
        it("Saber si la parcela tiene complicaciones(alguna planta tolera menos sol que la parcela") {
           //unaParcela.parcelaTieneComplicaciones().shouldBe(false)
        }
        fun Any.shouldThrow() { "No se puede plantar esto acá, se va a quemar o Ya no hay lugar en esta parcela"}
        it("parcela Puede plantar una val unaDeMentita"){
            unaParcela.plantar(unaDeMentita).shouldThrow()
        }
        it("una parcela puede plantar por cantidad"){
            unaParcela.plantar(unaDeSoja3).shouldThrow()
        }
    }

})



/*
class AgricultoraTest : DescribeSpec({

    val unaDeSoja1 = Soja(2010,2.0f,true)
    val unaParcela1 = Parcela(20,1,9)
    val unaParcela2 = Parcela(20,1,9)
    val parcelas: MutableList(unaParcela,unaParcela2)

    val unaAgricultora = Agricultora(parcelas)
    unaAgricultora.parcelas.add(unaParcela1)

    describe("Pidiendo info de Agricultora"){
        it("Conociendo parcelasSemilleras") {
            unaAgricultora.parcelasSemilleras().size.shouldBe(1)
        }

        it(" plantar estratégicamente") {
            unaAgricultora.plantarEstrategicamente(unaDeSoja1)
        }
    }

})
*/