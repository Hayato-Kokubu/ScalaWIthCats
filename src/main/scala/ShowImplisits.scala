import java.time.LocalDate
import cats.Show


object ShowImplisits {
  implicit val dateShow: Show[LocalDate] = {
    new Show[LocalDate]{
      def show(date: LocalDate): String =
      s"${date.getYear} 年 ${date.getMonth.getValue}月 ${date.getDayOfMonth}日"
    }
  }
}
