package `match`

object MatchSeqWithoutUnapplySeq {
  val nonEmptyList = List(1, 2, 3, 4, 5)
  val emptyList = Nil
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)

  // Process pairs
  def windows2[T](seq: Seq[T]): String = seq match {
    case head1 +: head2 +: tail => s"($head1, $head2), " + windows2(seq.tail)
    case head +: tail => s"($head, _), " + windows2(tail)
    case Nil => "Nil"
  }

  def main(args: Array[String]): Unit = {
    for (seq <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq))
      println(windows2(seq))
  }
}