(ns sicp-clj.exercise1_19)

;; SPECIAL CASE WHERE p = 0, q = 1

;; a -> bq + aq + ap => b + a
;; b -> bp + aq => a

;; a2 -> aq + (b + a)q + (b + a)p => 2aq + bq + bp + ap
;; b2 -> ap + (b + a)q => ap + bq + aq

;; GENERAL CASE:

;; a2 -> ((bp + aq)q + (bq + aq + ap)q + (bq + aq + ap)p)
;; a2 ->  bpq + aq^2 + bq^2 + aq^2 + apq + bqp + aqp + ap^2
;; a2 ->  2aq^2 + 2apq + ap^2 + 2bpq + bq^2 
;; p' -> (p^2 + q^2)
;; q' -> (q^2 + 2pq)

;; b2 -> ((bp + aq)p + (bq + aq + ap)q)
;; b2 ->  bp^2 + apq + bq^2 + aq^2 + apq
;; b2 -> bp^2 + bq^2 + aq^2 + 2apq

;; p' -> (p^2 + q^2)
;; q' -> (q^2 + 2pq)



;; b2 -> bp + aq + ((bp^2 + aqp + bq^2 + aq^2 + apq)

(defn square
  [x]
  (* x x))

(defn fib-iter
  [a b p q count]
  (cond
    (= count 0) b
    (even? count) (fib-iter a b 
                            (+ (* p p) (* q q)) 
                            (+ (* q q) (* 2 p q)) 
                            (/ count 2))
    :else (fib-iter (+ (* b q) (* a q) (* a p))
                    (+ (* b p) (* a q))
                    p q
                    (- count 1))))

(defn fib
  [n]
  (fib-iter 1 0 0 1 n))

(fib 5)
(fib 6)
(fib 7)
(fib 8)
(fib 9)
