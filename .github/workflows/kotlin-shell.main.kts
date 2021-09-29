import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.WeekFields
import java.util.Locale

println(args.toList())

val weekNumber: Int =
    LocalDate.now(ZoneId.of("Europe/Madrid"))
        .get(WeekFields.of(Locale("es", "ES")).weekOfWeekBasedYear())

println(weekNumber)
