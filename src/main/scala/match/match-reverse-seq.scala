package `match`

object MatchRevSeq {
  val nonEmptyList   = List(1, 2, 3, 4, 5)
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)
  val nonEmptyMap    = Map("one" -> 1, "two" -> 2, "three" -> 3)

  def reverseSeqToString[T](l: Seq[T]): String =
    l match {
      case prefix :+ end => reverseSeqToString(prefix) + s" :+ $end"
      case Nil => "Nil"
    }

  def main(args: Array[String]): Unit = {
    for (seq <- Seq(nonEmptyList, nonEmptyVector, nonEmptyMap.toSeq))
      println(reverseSeqToString(seq))
  }
}