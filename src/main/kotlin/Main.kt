class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            println(main.hello())
        }
    }

    fun hello(): String {
        return "Hello, World!"
    }
}