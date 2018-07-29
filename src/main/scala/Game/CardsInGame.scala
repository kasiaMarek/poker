package Game

import Cards.Card
import Hands._

object CardsInGame {


  def FindBestHand(initCards: List[Card]): Hand = {
    val cards = new StackOfCards(initCards)

    val hand = cards match {
      case ExStraightFlush(c) => Some(c)
      case ExFour(c) => Some(c)
      case ExFull(c) => Some(c)
      case ExStraight(c) => Some(c)
      case ExThree(c) => Some(c)
      case ExTwoPair(c) => Some(c)
      case ExOnePair(c) => Some(c)
     // case ExHighCard(c) => Some(c)
      case _ => Some(new HighCard(cards.asList.slice(0,5).map(c => c.rank)))
    }

    hand.get
  }
}
