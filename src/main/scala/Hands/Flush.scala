package Hands

import Game.StackOfCards

class Flush(sameSuitCardRanks: List[Int], otherCard: Int) extends HighCard(cardRanks = sameSuitCardRanks) {
  override def getValue: Int = 5

  override def compareSameType(hand: this.type): Int = {
    val sameSuitCompare = super.compareSameType(hand)

    if(sameSuitCompare == 0)
      otherCard.compare(hand.otherCard)
    else
      sameSuitCompare
  }
}

object ExFlush {
  def unapply(cards: StackOfCards) = {
    if(cards.suit != null) {
      val listOfFourInSuit = cards.asList.filter(c => c.suit == cards.suit).slice(0, 5)
      val otherCard = cards.asList.filter(c => !listOfFourInSuit.contains(c)).max
      Some(new Flush(listOfFourInSuit.map(c => c.rank), otherCard.rank))
    } else
      None
  }
}
