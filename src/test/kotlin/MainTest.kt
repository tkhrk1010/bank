import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainTest {

    @Test
    fun testHello() {
        val main = Main()
        assertEquals("Hello, World!", main.hello())
    }
}