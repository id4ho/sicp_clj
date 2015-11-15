(ns sicp-clj.exercise1_18)

(defn halve
  [x]
  (/ x 2))

(defn double [x] (+ x x))

(defn fast-mult-iter
  [x b]
  (defn mult-iter
    [x b times_to_double adder]
  (cond 
    (= b 1) (cond
              (> times_to_double 0) (mult-iter (double (+ x adder)) 1 (- times_to_double 1) 0)
              (= times_to_double 0) x)
    (even? b) (mult-iter x (halve b) (+ times_to_double 1) (halve adder))
    :else (mult-iter x (- b 1) times_to_double (+ adder x))))
  (mult-iter x b 0 0))

(fast-mult-iter 43 12)
(fast-mult-iter 5 10)
