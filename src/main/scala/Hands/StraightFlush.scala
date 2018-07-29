package Hands

import Cards.Suit
import Game.{MultiColorCard, StackOfCards}
import Hands.ExStraight.checkIfStraight

class StraightFlush(highestRank: Int) extends Straight(highestRank) {
  override def getValue: Int = 8
}

object ExStraightFlush {

  private def checkIfAllInSuit(cards: List[MultiColorCard], suit: Suit.Value): Boolean =
    suit != null && cards.forall(c => c.suits.contains(suit))


  def unapply(cards: StackOfCards) = {

    if(cards.suit != null) {
      val straightFlush = cards.asMulti.sliding(5).find(c => checkIfStraight(c) && checkIfAllInSuit(c, cards.suit))
      if (straightFlush.isDefined) Some(new StraightFlush(straightFlush.get.map(c => c.rank).max))
      else None
    } else None
  }
}


