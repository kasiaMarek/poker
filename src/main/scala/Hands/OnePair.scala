package Hands

class OnePair(val pair: Int, otherRanks: List[Int]) extends HighCard(cardRanks = otherRanks) {
  override def getValue: Int = 1

  override def compareSameType( hand : this.type) : Int = {
    if(pair > hand.pair) 1
    else if(pair < hand.pair) -1
    else super.compareSameType(hand)
  }
}
