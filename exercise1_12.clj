(ns sicp-clj.exercise1_12)

(defn level
  [index]
  (defn find_level
    [index, total, level]
    (if (> index total)
      (find_level index (+ total (+ level 1)) (+ level 1))
      level))
  (find_level index 1 1))

(defn summation
  [n]
  (/ (* n (+ n 1)) 2))

(defn pascal-triangle
  [index]
  (cond
    (= index (summation (level index))) 1
    (= index (- (summation (level index)) (- (level index) 1))) 1
    :else (+ (pascal-triangle (- index (level index)))
            (pascal-triangle (+ (- index (level index)) 1)))))

(pascal-triangle 21)

;      1
;    1   1
;   1  2  1
;  1  3 3  1
; 1 4  6  4 1
;1 5 10 10 5 1

