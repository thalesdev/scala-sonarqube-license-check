package common.example

case class Sum(a: Int, b: Int) {
  def eval: Int = a + b

  override def toString: String = eval.toString
}
