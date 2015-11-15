(ns sicp-clj.exercise1_10)

(defn A
  [x y]
  (cond
    (= y 0) 0
    (= x 0) (* 2 y)
    (= y 1) 2
    :else (A (- x 1)
             (A x (- y 1)))))

(A 1 10)
; => 2 ** 10
(A 2 4)
; (A 1 (A 1 (A 1 (A 2 1))))
; (A 1 (A 1 (A 1 (2))))
; (A 1 (A 1 (A 0 (A 1 1))))
; (A 1 (A 1 (A 0 (2))))
; (A 1 (A 1 (4)))
; (A 1 (A 0 (A 1 3)))
; (A 1 (A 0 (A 0 (A 1 2))))
; (A 1 (A 0 (A 0 (A 0 A(1 1)))))
; (A 1 (A 0 (A 0 (A 0 2))))
; (A 1 (A 0 (A 0 4)))
; (A 1 (A 0 8))
; (A 1 16)
; => 2 ** 16
(A 3 3)
; (A 2 (A 3 2))
; (A 2 (A 2 (A 3 1)))
; (A 2 (A 2 2))
; (A 2 (A 1 (A 2 1)))
; (A 2 (A 1 2))
; (A 2 (A 0 (A 1 1)))
; (A 2 (A 0 2))
; (A 2 4)
; => 2 ** 16

; (defn f
;   [n]
;   (A 0 n))
; This function will compute 2 * y

; (defn f
;   [n]
;   (A 1 n))
; This function will compute 2 ** y
; This is because (A 1 n) will return (A 0 (A 1 (- n 1)))
; and (A 0 n) as stated above will compute 2 * n
; this pattern can be extrapolated to 2 * 2 * 2 * .. for n number of 2's

; (defn f
;   [n]
;   (A 2 n))
; (A 2 n) reduces to (A 1 (A 2 (- n 1)))
; so we wind up with '2 ** ' n times. so at n = 1 we get 2 ** 1 and for each
; subsequent n we raise the 2 to the previous answer. if n = 2, 2 ** 2 ** 1 => 4
; in the above example:
; (A 2 4) => 2 ** 2 ** 2 ** 2 => 2 ** 2 ** 4 => 2 ** 16

