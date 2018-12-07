class JTest1 is
    var a : Integer

    method Square(temp: Integer) is
        var result : Integer(temp)
        result := result.Mult(temp)
        return
    end

    method main() is
        var a : Integer(12)
        a := Square(temp)
    end
end