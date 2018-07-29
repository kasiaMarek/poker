package Hands

case class Full(three: Int, two: Int) extends Hand {
  override def getValue: Int = 6

  override def compareSameType( hand : this.type) : Int = {
    if (three == hand.three) {
      if (two == hand.two) 0
      else two.compare(hand.two)
    } else three.compare(hand.three)
  }
}
