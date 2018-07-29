package Hands

class Three (three: Int, otherRanks: List[Int]) extends OnePair(pair = three, otherRanks) {
  override def getValue: Int = 3

}
