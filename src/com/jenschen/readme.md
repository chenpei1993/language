# 玩具脚本语言

## 主要流程
1. 词法解析
2. 文法解析

## 文法

```
expr -> term 

expr -> (plus | minus) term

term -> number 

term -> (mul | div) number 

number -> (plus | minus) number

number -> (expr)

number -> int | float

```

## 设计模式

- 解释器模式
- 迭代器模式


