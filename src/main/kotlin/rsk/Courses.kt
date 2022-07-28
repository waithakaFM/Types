package rsk

class Course (val Id: Int, val Title: String){

}

// object keyword is used to create singleto -> one thing that will be used all over the program
object Courses {
    var allCourses = arrayListOf<Course>()

    fun initialize(){
        allCourses.add(Course(1, "Kotlin Fundamentals"))
    }
}