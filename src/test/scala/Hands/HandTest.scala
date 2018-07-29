package Hands

class HandTest extends org.scalatest.FlatSpec {

  "Hand" should "compare objects of different types according to value assigned to them" in {
    val flush = new Flush(List())
    val four = new Four(List(), 5)

    assert(flush.compare(four) == -1)
  }

}
