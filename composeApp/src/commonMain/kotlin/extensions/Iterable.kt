package extensions

@kotlin.jvm.JvmName("averageNotZeroOfInts")
fun Iterable<Int>.averageNotZero(): Double {
  val elements = this.filter { it != 0 }
  if (elements.isEmpty()) {
    return 0.0
  }
  return elements.average()
}

@kotlin.jvm.JvmName("averageNotZeroOfDoubles")
fun Iterable<Double>.averageNotZero(): Double {
  val elements = this.filter { it != 0.0 }
  if (elements.isEmpty()) {
    return 0.0
  }
  return elements.average()
}
