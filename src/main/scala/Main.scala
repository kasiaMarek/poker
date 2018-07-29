object Main {
  def prob( p: Double ) : Double = 1-p

  def main(args: Array[String]) {
    val c = "a" :: ("c" :: Nil)
    println(c.slice(5,6))
  }
}
