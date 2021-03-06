# 玩具脚本语言

## 主要流程
1. 词法解析
2. 文法解析

## 文法

```****

expr -> variableSymbol identifier = compareExpr
expr -> compareExpr logicSymbol compareExpr
expr -> notLogicSymbol compareExpr
expr -> if compareExpr then expr else expr
expr -> while compareExpr then expr end
expr -> identifier = compareExpr
expr -> callExpr

callExpr -> identifier ((identifier (, identifier)*)?)

compareExpr -> arithmeticExpr | arithmeticExpr compareSymbol arithmeticExpr
compareExpr -> (compareExpr)
compareExpr -> true | false
compareExpr -> methodSymbo

arithmeticExpr -> term 
arithmeticExpr -> plusMinus term

term -> number | identifier
term -> mulDivModePow number
term -> mulDivModePow identifier

number -> plusMinus number
number -> (arithmeticExpr)
number -> int | float

identifier -> string
plusMinus -> + | -
mulDivModePow -> mul | div | mode | pow
compareSymbol -> > | < | >= |  <= | ==
logicSymbol -> and | or
notLogicSymbol -> not
variableSymbol -> let | const
methodSymbo -> func identifier ((identifier (, identifier)*)?) then expr end
```

## 语法规则

### 注释
使用#符号表示注释，以\n结尾
```
# while function
```

### 赋值预算
```
let a = 1  # a == 1
let a = let b = 1 # a == b == 1
```

### 逻辑运算
```
1 and 0 # true
1 and -1 # false
1 or -1 # true
```

### 函数

#### 默认函数
```
let a = 1
print(a)
```

####自定义函数

### 循环运算
```
let a = 1
while(a > 10){
    a = a + 1
}
print(a)
```
### 选择判断
```
let a = 1
let b
if a >= 1 then
    b = 1
else
    b = 2
    
print(b)
```

## 运行方法

### 文件运行

文件的后缀名需要是以.cp结尾。

**文件的换行符只支持\n**