package Cards

class Card(val rank: Int, val suit: Suit.Value) {

  def <(card : Card) : Boolean = rank < card.rank

  def >(card : Card) : Boolean = rank > card.rank

  def ==(card : Card) : Boolean = rank == card.rank && suit == card.suit

  def compare(card: Card): Int = rank.compare(card.rank)

}
