package Hands

import Game.StackOfCards

class Four (four: Int, otherRanks: List[Int]) extends OnePair(pair = four, otherRanks: List[Int]) {
  override def getValue: Int = 7

}

object ExFour {

  def unapply(cards: StackOfCards) = {
    val four = cards.asMulti.find(c => c.suits.length == 4).orNull
    if(four != null) {
      val maxCard = cards.asMulti.filter(c => c.suits.length == 4).max
      Some(new Four(four.rank, List(maxCard.rank)))
    } else None
  }

}
