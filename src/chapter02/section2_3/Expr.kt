package chapter02.section2_3

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr