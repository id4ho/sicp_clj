(ns sicp-clj.exercise1_21)

;; Remainder of a / b
(defn remainder
  [a b]
  (loop [a a b b]
    (cond (> b a) 
          a 
          :else (recur (- a b) b))))

(defn square
  [n]
  (* n n))

;; Does a divide b with no remainder?
(defn divides?
  [a b]
  (= (remainder b a) 0))

(defn find-divisor
  [n]
  (loop [num n d 2]
    (cond
      (> (square d) num) num
      (divides? d num) d
      :else (recur num (+ d 1)))))

(defn smallest-divisor
  [n]
  (find-divisor n))

(smallest-divisor 19999)
