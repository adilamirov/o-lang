var a : Array[Integer](10)
a.set(i) := 55
x := a.get(i.Plus(1))
var i is 1
while i.LessEqual(a.Size) loop
    x := a.get(i)
    a.set(i,x.Mult(x))
    i := i.Plus(1)
end
class C[T] is
    var m : T
end
var y : Array[Integer](10)
var k : List[Real]
var m : Integer(1)
var b : true
var b : Boolean(true)
var x : Base(1,2)
x := Derived(3)