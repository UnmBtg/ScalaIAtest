class Population(selection: List[Int] => Int) {

  var people = List.tabulate(Settings.POPULATION_SIZE)(n => new Person(selection))


  def Fittest(): Person ={
    higher(people)
  }

  def SecondFittest() : Person = {
    var highest = Fittest()
    higher(people.filter(n => n != highest))
  }

  def higher(ppl: List[Person]) : Person = {
    ppl.reduce( (x, y)  => if (x.fittness > y.fittness) x else y)
  }

  def crossOver(thingy: Person, thingy2: Person): Unit = {
    var initial = new Person(selection, thingy.capacity.take(5) ++ thingy2.capacity.take(5))

    var list = List.tabulate(Settings.POPULATION_SIZE - 2)(n => initial.procreate(initial.capacity))
    var listPeople = list ++ List(initial, Fittest())

    people = listPeople
  }

}
