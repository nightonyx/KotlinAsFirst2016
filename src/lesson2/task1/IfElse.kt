@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */

fun ageDescription(age: Int): String {
    val num = age % 10
    if (age % 100 in 5..19)
        return "$age лет"
    if (num in 5..9)
        return "$age лет"
    if (num == 0)
        return "$age лет"
    if (num == 1)
        return "$age год"
    if (num in 2..4)
        return "$age года"
    return "invalid input"
}


/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val s1 = v1 * t1
    val s2 = v2 * t2
    val s3 = v3 * t3
    val lenght =  (s1 + s2 + s3) / 2.0
    if(s1 > lenght)
        return lenght / v1
    if(s1 + s2 > lenght)
        return t1 + (lenght - s1) / v2
    if(s1 + s2 + s3 > lenght)
        return (t1 + t2 + (lenght - s1 - s2 ) / v3)
    return Double.NaN
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    var answer = 0
    if(kingX == rookX1 || kingY == rookY1)
        answer++
    if(kingX == rookX2 || kingY == rookY2)
        answer+=2
    return answer


}
/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    var answer = 0
    if(rookX == kingX || rookY == kingY)
        answer++
    if(Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY))
        answer+=2
    return answer
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val a2 = Math.pow(a, 2.toDouble())
    val b2 = Math.pow(b, 2.toDouble())
    val c2 = Math.pow(c, 2.toDouble())
    if(a + b < c)
        return -1
    if(a2 + b2 > c2)
        return 0
    if(a2 + b2 == c2)
        return 1
    if(a2 + b2 < c2)
        return 2
    return -2
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    var crossing = 0
    if((d >= a) && (d >= b) && (c >= a))
        crossing = b - c
    if((a >= c) && (b >= d) && (d >= a))
        crossing = d - a
    if((a >= c) && (b >= c) && (d >= b))
        crossing = b - a
    if((d >= a) && (b >= d) && (c >= a))
        crossing = d - c
    if(((c > a) && (c > b)) || ((a > c) && (a > d)))
        crossing = -1
    return crossing
}