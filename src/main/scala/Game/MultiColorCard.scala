package Game

import Cards.{Card, Suit}

class MultiColorCard(card: Card) {
  val rank = card.rank
  var suits: List[Suit.Value] = card.suit :: Nil

  def addSuit(c: Suit.Value): Unit =  { suits = c :: suits }

  def numOfSuit: Int = suits.length
}
