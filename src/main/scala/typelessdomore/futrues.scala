package typelessdomore

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureDriver {
  def main(args: Array[String]): Unit = {

    (1 to 5) foreach { index: Int =>
      val future = Future {
        doWork(index)
      }

      future onSuccess  {
        case answer: Unit => println(s"Success! returned: $index")
      }

      future onFailure{
        case th: Throwable => println(s"FAILURE! returned: $th")
      }
    }

    def sleep(millis: Long) = {
      Thread.sleep(millis)
    }

    def doWork(index: Int) = {
      sleep((math.random * 1000).toLong)
    }

    sleep(1000)
    println("Finito!")
  }
}



