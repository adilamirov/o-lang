class JTest2 extends JTest1 is
    var value : Integer


    this(temp: Real) is
        this.value := temp.toInteger(temp)
    end


    this(temp: Integer) is
        this.value := temp
    end


    method SquareMinusOne(temp: Integer) : Integer is
        var result: Integer
        var result := this.Square(temp)
        result := result.Minus(1)
        return result
    end


    method SumFromOneToN(n: Integer) : Integer is
        var result : Integer(1)
        var i : Integer(1)
        while i.LessEqual(n) loop
            result := result.Plus(i)
            i := i.Plus(1)
        end
    end

    method SumOfArray (arr : Array[Real]) : Real is
        var i : Integer(0)
        var result : Real(0)
        while i.Less(arr.Size) loop
            result := result.Plus(arr.get(i))
        end
        return result
    end
end













