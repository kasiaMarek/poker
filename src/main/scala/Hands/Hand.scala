package Hands

 trait Hand { // cards pre-sorted from highest to lowest
 // def Hand : Unit = cards.sortWith(_<_)
  def getValue: Int

//  def >(hand: Hand): Boolean = getValue > hand.getValue && compareSameType(hand) == 1
//  def ==(hand: Hand): Boolean = getValue == hand.getValue && compareSameType(hand) == 0
//  def <(hand : Hand): Boolean = getValue < hand.getValue && compareSameType(hand) == -1
//  def <=(hand : Hand): Boolean = this < hand || this == hand
//  def >=(hand : Hand): Boolean = this > hand || this == hand

  def compare(hand : Hand): Int = {
    if(getValue > hand.getValue) 1
    else if(getValue < hand.getValue) -1
    else compareSameType(hand.asInstanceOf[this.type])
  }

  def compareSameType(hand : this.type) : Int


}
