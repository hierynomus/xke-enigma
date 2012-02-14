import org.scalatest.{BeforeAndAfter, FunSpec}

class ReflectorSpec extends FunSpec with BeforeAndAfter {

  var reflector: Reflector = _
  
  before {
    reflector = new Reflector(Alphabets.reflector)
  }
  
  describe("A reflector") {
    it("should reflect a position into its counterpart position") {
      assert(reflector.reflect(0) === 24)
    }
  }
}
