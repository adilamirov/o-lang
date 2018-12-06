class First is
    var s : Array[Integer](10)
    var r : Real
    var i : Integer
    var j : Integer
    var n : Integer

    method MethodA (x: Integer, y: Real) : Integer is
        while i.LessEqual(s.Size) loop
            n := 0
            while j.LessEqual(s.Size) loop
                 if s[i]=s[j] then
                    inc(n)
                 end
                 r:=r+1/n
            end
        writeln(\'numberof different letters = \', r:1:0)
                        "end
    end
end