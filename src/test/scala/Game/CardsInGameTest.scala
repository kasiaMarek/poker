package Game

import Cards.{Card, Suit}

class CardsInGameTest extends org.scalatest.FlatSpec {

  "majorityColor" should "return the suit if it appears in cards 5 or more times" in {
    val list = List(new Card(2, Suit.SPADE), new Card(3, Suit.HEART), new Card(7, Suit.SPADE),
      new Card(4, Suit.SPADE), new Card(7, Suit.CLUB), new Card(12, Suit.SPADE), new Card(10, Suit.SPADE))

    assert(CardsInGame.majorityColor(list) == Suit.SPADE)

  }
}
