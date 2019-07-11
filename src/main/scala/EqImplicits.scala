import java.time.LocalDateTime

import cats.kernel.Eq

object EqImplicits {
  // 分まで一緒であれば同じとみなす
  implicit val localDateTimeEq: Eq[LocalDateTime] =
    Eq.instance[LocalDateTime] { (t1, t2) =>
      t1.getYear == t2.getYear &&
      t1.getMonth == t2.getMonth &&
      t1.getDayOfMonth == t2.getDayOfMonth &&
      t1.getHour == t2.getHour &&
      t1.getMinute == t2.getMinute
    }
}
