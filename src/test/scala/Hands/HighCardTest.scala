package Hands

import Cards.{Card, Suit}
import org.scalatest.FlatSpec

class HighCardTest extends FlatSpec {

  "Hand" should "compare according to the highest card" in {
    val h1 = new HighCard(List(new Card(5, Suit.SPADE), new Card(12, Suit.HEART), new Card(3, Suit.SPADE)))
    val h2 = new HighCard(List(new Card(7, Suit.SPADE), new Card(12, Suit.SPADE), new Card(2, Suit.SPADE)))
    assert(h1.compare(h2) == -1)
  }

}
