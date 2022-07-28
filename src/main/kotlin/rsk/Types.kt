package rsk

interface Time {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
    fun setTime(time: FrankoTime) = setTime(time.hours)
}

interface EndOfTheWorld {
    fun setTime(time: FrankoTime) {}
}

class FrankoTime{
    var hours: Int =0
    var mins = 0
    var seconds = 0
}

// class Yetitime implement interface time
class YetiTime : Time, EndOfTheWorld {
//    overriding the function

    override fun setTime(time: FrankoTime) {
//        specify which function to use, and from which interface
        super<Time>.setTime(time)
        super<EndOfTheWorld>.setTime(time)
    }
    override fun setTime(hours: Int, mins: Int, secs: Int) {}
}