package Hands

import Game.{MultiColorCard, StackOfCards}

class Straight(highestRank: Int) extends Hand {
  override def getValue: Int = 4

  override def compareSameType(hand: this.type) : Int  = highestRank.compare(hand.highestRank)

}

object ExStraight {

  def checkIfStraight(ranks: List[MultiColorCard]): Boolean = //checks if in 5 different ranks is a straight
    ranks.length == 5 && ranks.sliding(2).forall(value => value.head.rank + 1 == value.apply(1).rank)


  def unapply(cards: StackOfCards) = {

    val straight = cards.asMulti.sliding(5).find(ranks => checkIfStraight(ranks))

    if(straight.isDefined) Some(new Straight(straight.get.map(c => c.rank).max))
    else None
  }
}