package Hands

import Game.StackOfCards

class OnePair(val pair: Int, otherRanks: List[Int]) extends HighCard(cardRanks = otherRanks) {
  override def getValue: Int = 1

  override def compareSameType( hand : this.type) : Int = {
    if(pair > hand.pair) 1
    else if(pair < hand.pair) -1
    else super.compareSameType(hand)
  }
}


object ExOnePair {

  def getInSameSuit(cards: StackOfCards, numOfCards: Int): Option[(Int, List[Int])] = {
    val sameSuit = cards.asMulti.find(c => c.suits.length == numOfCards)
    if(sameSuit.isDefined) {
      val sameSuitRank = sameSuit.get.rank
      Some((
        sameSuitRank,
        cards.asMulti.map(c => c.rank).filter(r => r != sameSuitRank).sortWith(_ > _).slice(0, 5 - numOfCards)
      ))
    }
    else
      None
  }

  def unapply(cards: StackOfCards): Option[Hand] = {
    val pair = getInSameSuit(cards, 2)

    if(pair.isDefined) Some(new OnePair(pair.get._1, pair.get._2))
    else None

  }

}
