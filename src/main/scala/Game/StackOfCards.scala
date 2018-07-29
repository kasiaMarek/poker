package Game

import Cards.{Card, Suit}

class StackOfCards(initCards: List[Card]) {

  val asList: List[Card] = initCards.sortWith((x, y) => x.rank > y.rank)
  val asMulti: List[MultiColorCard] = addAllCards(initCards)
  val suit: Suit.Value = majorityColor(initCards)

  private def addAllCards(initCards: List[Card]): List[MultiColorCard] = {
    var cards: List[MultiColorCard] = Nil
    initCards.foreach(c => cards = addCard(c, cards))
    cards.sortWith((x, y) => x.rank > y.rank)
  }

  private def addCard(card: Card, cards: List[MultiColorCard]): List[MultiColorCard] = {
    val cardWithSameRank: Option[MultiColorCard] = cards.find(c => c.rank == card.rank)

    if(cardWithSameRank.isDefined) {
      cardWithSameRank.get.addSuit(card.suit)
      cards
    }
    else new MultiColorCard(card) :: cards
  }

  def majorityColor(cards: List[Card]): Suit.Value = { //checks if flush
    var suits: Map[Suit.Value, Int] = Suit.values.map(v => v -> 0).toMap

    cards.foreach(c => suits = suits + (c.suit -> (suits.getOrElse(c.suit, 0) + 1)))

    val out = suits.find(v => v._2 >= 5)
    if(out.isDefined) out.get._1
    else null
  }

}
