class JTest is
    var a : Integer

    method Square(temp: Integer) is
        var result : Integer(temp)
        result := result.Mult(temp)
        return
    end

    method main() is
        var a : Integer(12)
        var b : Integer(23)
        if a.Equal(b) then
            a.Plus(3)
        else
            b.Plus(3)
        end
    end
end
