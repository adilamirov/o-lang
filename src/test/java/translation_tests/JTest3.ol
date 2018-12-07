aclass JTest is

     var a : Integer

     method JTest() is
         var x : Integer(22)
         a.Plus(123)
     end

     method JTest1(x : Integer) is
             a.Plus(x)
     end

     method somethingseomyhin(x : Real, y : Real) is
         while x.LessEqual(12) loop
             y := y.Plus(1)
         end
         return
     end

     method somethingseomyhin(x : Integer, y : Real) is
         while x.LessEqual(5) loop
             y := y.Plus(1)
         end
         return
     end
 end
