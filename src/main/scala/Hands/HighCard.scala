package Hands

import Game.StackOfCards

class HighCard(cardRanks: List[Int]) extends Hand {
  override def getValue: Int = 0

  override def compareSameType(hand: this.type): Int  = {

    def compareCardLists(list1 : List[Int], list2 : List[Int]) : Int = {
      if(list1.isEmpty || list2.isEmpty)
        0
      else {
        if (list1.head < list2.head)
          -1
        else if (list1.head > list2.head)
          1
        else
          compareCardLists(list1.drop(0), list2.drop(0))
      }
    }

    compareCardLists(cardRanks, hand.cardRanks)

  }
}

//object ExHighCard {
//
//  def unapply(cards: StackOfCards) = Some(new HighCard(cards.asList.slice(0,5).map(c => c.rank)))
//
//}
