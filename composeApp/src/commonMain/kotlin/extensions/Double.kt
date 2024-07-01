package extensions

import kotlin.math.ceil

fun Double.nanToZero(): Double {
  if (this.isNaN()) {
    return 0.0
  }
  return this
}

fun Double.format(): String {
  return (ceil(this.nanToZero() * 10.0) / 10.0).toString().replace('.', ',')
}
