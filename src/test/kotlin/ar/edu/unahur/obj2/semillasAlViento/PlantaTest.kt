package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PlanaTest : DescribeSpec({
    val sojita = Soja(2007, 1.18F)
    //val sojota = Soja(2012, 1.44F)
    val ment1 = Menta(1986, 0.18F)

    describe("ment1 - test "){

        it ("ment1 hora que tolera"){
            ment1.horasDeSolQueTolera().shouldBe(6)
        }
        it(" Ment1 ¿es fuerte? "){
            ment1.esFuerte().shouldBe(false)
        }
        it("ment1 altura"){
            ment1.altura.shouldBe(0.18F)
        }
    }
    describe("sojita - test "){

        it ("sojita hora que tolera"){
            sojita.horasDeSolQueTolera().shouldBe(9)
        }
        it(" sojita ¿es fuerte? "){
            sojita.esFuerte().shouldBe(false)
        }
        it("sojita altura"){
            sojita.altura.shouldBe(1.18F)
        }
    }
})
