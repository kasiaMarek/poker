package Hands

import Game.StackOfCards

class TwoPair(highPair: Int, lowPair: Int, otherCard: Int) extends Hand {
  override def getValue: Int = 2

  override def compareSameType(hand : this.type) : Int = {
    if (highPair == hand.highPair) {
      if (lowPair == hand.lowPair) otherCard.compare(hand.otherCard)
      else lowPair.compare(hand.lowPair)
    } else highPair.compare(hand.highPair)
  }
}

object ExTwoPair {

  def unapply(cards: StackOfCards): Option[Hand] = {
    val twoPair = cards.asMulti.filter(c => c.suits.length == 2).map(c => c.rank).sortWith(_>_).slice(0, 2)

    if(twoPair.length == 2)
      Some( new TwoPair(
        twoPair(0),
        twoPair(1),
        cards.asMulti.map(c => c.rank).filter(r => !twoPair.contains(r)).max
      ))
    else
      None
  }

}

