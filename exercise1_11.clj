(ns sicp-clj.exercise1_11)

(defn eleven-recursive
  [n]
  (if (< n 3)
    n
    (+ (eleven-recursive (- n 1))
       (* 2 (eleven-recursive (- n 2)))
       (* 3 (eleven-recursive (- n 3))))))

(defn eleven-iter
  [n]
  (defn f-iter
    [current finish one-ago two-ago three-ago]
    (def this-one
      (+ one-ago (* 2 two-ago) (* 3 three-ago)))
    (if (= current finish)
      this-one
      (f-iter (+ current 1) finish this-one one-ago two-ago)))
  (if (< n 3)
    n
    (f-iter 3 n 2 1 0)))

(eleven-recursive 9)
(eleven-iter 50)

