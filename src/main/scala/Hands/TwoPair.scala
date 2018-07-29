package Hands

class TwoPair(highPair: Int, lowPair: Int, otherCard: Int) extends Hand {
  override def getValue: Int = 2

  override def compareSameType(hand : this.type) : Int = {
    if (highPair == hand.highPair) {
      if (lowPair == hand.lowPair) otherCard.compare(hand.otherCard)
      else lowPair.compare(hand.lowPair)
    } else highPair.compare(hand.highPair)
  }
}

