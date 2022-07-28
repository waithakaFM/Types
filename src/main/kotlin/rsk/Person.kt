package rsk

fun main(args: Array<String>) {
    val franko = Student("Franko", "Mwas", 1)
    val johnny = Student("Johnny", "Karis", 2, "My Tutor")

    print(franko.id)
}

// class in kotlin are final by default: to make them accessible we use open keyword
abstract class Person(var firstName: String, var lastName: String) {
    open fun getName(): String = "$firstName $lastName"
    abstract fun getAdress(): String
}

// class student extend from person-> the last parameter tutor act as in secondary constructor
class Student( firstName: String, lastName: String, _id: Int, var tutor: String = "") : Person(firstName, lastName){
    val id: Int

//   init block is the first to be executed when the class is instantiated
    init {
        id = _id
    }

    override fun getName(): String {
        return super.getName()
    }

//    any abstract class or method must be implemented by its subclass
    override fun getAdress(): String {
        return ""
    }
}