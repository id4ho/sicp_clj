(ns sicp-clj.exercise1_17)

(defn halve
  [x]
  (/ x 2))

(defn my-double [x] (+ x x))

(defn fast-mult
  [x b]
  (cond
    (= b 1) x
    (even? b) (my-double (fast-mult x (halve b)))
    :else (+ x (fast-mult x (- b 1)))))

(fast-mult 43 12)

