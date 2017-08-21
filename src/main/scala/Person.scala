class Person (
              selection : List[Int] => Int,
             capacities : List[Int] = List.tabulate(Settings.CAPACITIES_SIZE)(n => (Math.random() * 100).toInt)
            )
{
  var capacity = capacities
  var fittness = selection(capacities)


  def procreate(capacities: List[Int], remains: Int = Settings.MUTATION_LEVEL): Person = {
    if (remains == 0) {
      return new Person(selection, capacities)
    }
    val rnd = new scala.util.Random

    procreate(
      capacities.updated(rnd.nextInt(Settings.POPULATION_SIZE), ( Math.random() *100).toInt),
      remains - 1
    )


  }
}
