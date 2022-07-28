package rsk

fun main(args: Array<String>) {
    val franko = Student("Franko", "Mwas", 1)
    val johnny = Student("Johnny", "Karis", 2, "My Tutor")

    print(franko.id)

//    calling the companion obj
    Student.createPostgrad("Jonte")
    Student.createUndergrad("Sammie")
}

// class in kotlin are final by default: to make them accessible we use open keyword
abstract class Person(var firstName: String, var lastName: String) {
    open fun getName(): String = "$firstName $lastName"
    abstract fun getAdress(): String
}

// class student extend from person-> the last parameter tutor act as in secondary constructor
open class Student( firstName: String, lastName: String, _id: Int, var tutor: String = "") : Person(firstName, lastName){
    val id: Int

//   init block is the first to be executed when the class is instantiated
    init {
        id = _id
    }

//    iterate over our set of courses and get the course we care about
    fun enrole(courseName: String){
//    goes to the singeton course, look for a title equal to courseName if not found return null
        val course = Courses.allCourses
            .filter{it.Title == courseName}
            .firstOrNull()
    }

    override fun getName(): String {
        return super.getName()
    }

//    any abstract class or method must be implemented by its subclass
    override fun getAdress(): String {
        return ""
    }

//    use a companion object to create factory method and implement an interface
    companion object: XmlSerializer<Student>{
        fun createUndergrad(name: String): Undergraduate{
            return Undergraduate(name)
        }

        fun createPostgrad(name: String): Postgraduate {
            return Postgraduate(name)
        }


        override fun toXml(item: Student) {

        }
}
}

class Undergraduate(firstName: String): Student(firstName, "", 1){

}

class Postgraduate(firstName: String): Student(firstName, "", 1){

}

interface XmlSerializer<T>{
    fun toXml(item: T)
}


