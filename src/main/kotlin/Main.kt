import `interface`.AccountInterface

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val main = Main()
//            println(main.hello())
            AccountInterface().main()

        }
    }

    fun hello(): String {
        return "Hello, World!"
    }
}