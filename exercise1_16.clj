(ns sicp-clj.exercise1_16)

(defn fast-expt-iter
  [a b n]
  (cond
    (= n 0) a
    (even? n) (fast-expt-iter a (* b b) (/ n 2))
    :else (fast-expt-iter (* a b) b (- n 1))))

(defn expt
  [b n]
  (fast-expt-iter 1 b n))

(expt 2 18)

