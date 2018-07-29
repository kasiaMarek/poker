package Hands

import Game.StackOfCards
import Hands.ExOnePair.getInSameSuit

class Three (three: Int, otherRanks: List[Int]) extends OnePair(pair = three, otherRanks) {
  override def getValue: Int = 3

}


object ExThree {

  def unapply(cards: StackOfCards): Option[Hand] = {
    val three = getInSameSuit(cards, 3)

    if(three.isDefined) Some(new OnePair(three.get._1, three.get._2))
    else None

  }

}
