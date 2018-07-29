package Hands

import Game.StackOfCards

case class Full(three: Int, two: Int) extends Hand {
  override def getValue: Int = 6

  override def compareSameType( hand : this.type) : Int = {
    if (three == hand.three) {
      if (two == hand.two) 0
      else two.compare(hand.two)
    } else three.compare(hand.three)
  }
}

object ExFull {

  def unapply(cards: StackOfCards): Option[Hand] = {
    val three = cards.asMulti.find(c => c.suits.length == 3)

    if(three.isDefined) {
      val two = cards.asMulti.filter(c => !(c.rank == three.get.rank && c.suits.length == 2)).max
      if(two != null) Some( new Full(three.get.rank, two.rank))
      else None
    } else None
  }

}
