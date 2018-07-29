package Game

import Cards.{Card, Suit}
import Hands._

object CardsInGame {


  private def findThreeCards(): MultiColorCard = null

  private def findTwoCards(): MultiColorCard = null

 // --------------------------------------



  private def findFull(): Hand = null

  private def findStraight(): Hand = null

  private def findThree(): Hand = null

  private def findTwoPair(): Hand = null

  private def findPair(): Hand = null


//--------------------------------------------------------------

//  def FindBestHand(initCards: List[Card]): Hand = {
//    val cards = new StackOfCards(initCards)
//     // check for color
//
//    val straightList = findStraights(cards)
//
//    val priorityList: List[Hand] =
//      List(
//          findStraightFlush(cards, suit, straightList),
//          findFour(cards),
//          findFull(),
//          findFlush(initCardsSorted, suit),
//          findStraight(),
//          findThree(),
//          findTwoPair(),
//          findPair(),
//          findHighestCard(initCardsSorted)
//      )
//
//    priorityList.find(h => h != null).get
//
//  }
}
