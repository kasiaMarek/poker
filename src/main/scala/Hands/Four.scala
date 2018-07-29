package Hands

import Game.StackOfCards
import Hands.ExOnePair.getInSameSuit

class Four (four: Int, otherRanks: List[Int]) extends OnePair(pair = four, otherRanks: List[Int]) {
  override def getValue: Int = 7

}

object ExFour {

  def unapply(cards: StackOfCards): Option[Hand] = {
    val four = getInSameSuit(cards, 4)

    if(four.isDefined) Some(new OnePair(four.get._1, four.get._2))
    else None

  }

}
