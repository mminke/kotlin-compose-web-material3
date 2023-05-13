package web.compose.material3.example

import kotlin.math.roundToInt

/**
 * This generates formatting functions for applying aggregating units (e.g. Kilo, Mega)
 * to values.  If you run out of units it gives up and shows the unit value.
 * NB This method is usable verbatim in Kotlin/JS.
 *
 * @param base The unit base, e.g. 1024 for bytes, 1000 for metric units of measure.
 * @param units the names of the units starting with the base unit (e.g. byte, meter).
 */
fun formatUnits(base: Int, units: List<String>): (Double, Int) -> String {
    check(1 < base)
    check(units.isNotEmpty())
    return { value, precision ->
        check(0 <= precision)
        tailrec fun haveAtIt(unitsTail: List<String>, adj: Double): String {
            if (unitsTail.isEmpty()) {
                return "$value${units.first()}"
            }
            if (adj < base) {
                val formatter: Double = precision.let {
                    var i = 1.0
                    for (q in 0 until precision)
                        i *= 10.0
                    i
                }
                val mag = ((adj * formatter).roundToInt() / formatter).toString().let {
                    if (it.endsWith(".0")) it.substring(0..it.length - 3)
                    else it
                }
                return "$mag${unitsTail.first()}"
            }
            return haveAtIt(unitsTail.drop(1), adj / base)
        }
        haveAtIt(units, value)
    }
}

private val formatBytesImpl = formatUnits(1024, listOf("B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"))
fun formatBytes(bytes: Int): String = formatBytesImpl(bytes.toDouble(), 2)

