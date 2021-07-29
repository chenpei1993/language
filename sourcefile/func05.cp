#测试代码
const a = 1
const b = 1
func test(a, b) then
    if b < 3 then
        b = b + 1
    else
        b = b + 2
    while a < 5 then
        a = a + 1
    end
end
test(a, b)
print(a)
print(b)
#--------------注释---------
let c = 1
let d = 1
test(c, d)
print(c)
print(d)