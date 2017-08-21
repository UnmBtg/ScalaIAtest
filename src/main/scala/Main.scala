object Main extends App {
  var generation = 0

  var selection = (capacities: List[Int]) => {
    capacities.count(n => n >= 5 && n <= 10)
  }

  var population = new Population(selection)

  while (population.Fittest().fittness < 10) {
    println(s"Geração ${generation}")
    println(population.people.length)
    println(s"Melhor ${population.Fittest().fittness}")
    println(s"Segue População: ");
    population.Fittest().capacity.foreach(n => print(s"${n.toString()},"))
    population.crossOver(population.Fittest(), population.SecondFittest())

    generation += 1

  }

  println(s"Geração ${generation}")
  println(population.people.length)
  println(s"Melhor ${population.Fittest().fittness}")
  println(s"Segue População: ");
}
