package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class PlantaTest : DescribeSpec({

val unaDeMenta = Menta(2005,10.0f)
val unaDeSoja = Soja(2010,2.0f,true)

    describe("planta 1 de menta"){
        it("de Menta horas De Sol Que Tolera") {
            unaDeMenta.horasDeSolQueTolera().shouldBe(6.0)
        }
        it("de Menta da Semillas") {
            unaDeMenta.daSemillas().shouldBeTrue()
        }
        it("de Menta es Fuerte") {
            unaDeMenta.esFuerte().shouldBeFalse()
        }
    }
    describe("planta 1 de soja") {
        it("De soja horas De Sol Que Tolera") {
            unaDeSoja.horasDeSolQueTolera().shouldBe(18.0)
        }
        it("De soja daSemillas") {
            unaDeSoja.daSemillas().shouldBeFalse()
        }
        it("De soja esFuerte") {
            unaDeSoja.esFuerte().shouldBeTrue()
        }
    }

})

class ParcelaTest : DescribeSpec({
    val unaParcela = Parcela(20,1,9)
    val unaDeSoja1 = Soja(2010,2.0f,true)
    val unaDeSoja2 = Soja(2010,2.0f,true)
    val unaDeSoja3 = Soja(2010,2.0f,true)
    val unaDeSoja4 = Soja(2010,2.0f,true)

    unaParcela.plantas.add(unaDeSoja1)
    unaParcela.plantas.add(unaDeSoja2)
    unaParcela.plantas.add(unaDeSoja3)
    unaParcela.plantas.add(unaDeSoja4)

    describe("Pidiendo info de unaParcela"){
        it("Conociendo superficie") {
            unaParcela.superficie().shouldBe(20)
        }
        it("cantidad Maxima Plantas ") {
            unaParcela.cantidadMaximaPlantas().shouldBe(4)
        }
        it("parcela tiene complicaciones") {
            //saber si tiene complicaciones, lo cual es así si alguna de sus
            // plantas tolera menos sol del que recibe la parcela;
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