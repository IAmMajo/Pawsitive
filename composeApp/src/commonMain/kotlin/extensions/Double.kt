package extensions

import kotlin.math.ceil

fun Double.format(): String {
  return (ceil(this * 10.0) / 10.0).toString().replace('.', ',')
}
