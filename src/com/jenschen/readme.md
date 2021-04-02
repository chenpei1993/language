# 玩具脚本语言

## 主要流程
1. 词法解析
2. 文法解析

## 文法

```****
expr -> term 

expr -> identifier

expr -> (plus | minus) term

expr -> (let | const) identifier = expr

term -> number

term -> (mul | div | mode | pow) (number | identifier)

number -> (plus | minus) number

number -> (expr)

number -> int | float

identifier -> string

```

## 设计模式

- 迭代器模式
- 组合模式
