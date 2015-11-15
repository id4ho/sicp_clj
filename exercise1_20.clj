(ns sicp-clj.exercise1_20)

(defn remainder
  [a b]
  (if (> b a) a (remainder (- a b) b)))

(defn gcd
  [a b]
  (if (= b 0) a (gcd b (remainder a b))))

(gcd 206 40)

;; Applicative-order Evaluation
;; (rem is evaluted and set as the local b for the next call)

;; (gcd 206 40)
;; (gcd 40 (remainder 206 40)) => 1 rem call
;; (gcd 6 (remainder 40 6)) => 1 rem call
;; (gcd 4 (remainder 6 4)) => 1 rem call
;; (gcd 2 (remainder 4 2)) => 1 rem call
;; #=> 2


;; Normal-order Evaluation
;; (b is evaluated in the if each call, a is evaluated at the end)

;; (gcd 206 40)
;; (gcd 40 (rem 206 40))
;;    => 1 rem call in the if
;; (gcd (rem 206 40) (rem 40 (rem 206 40))) 
;;    => 2 rem calls in the if
;; (gcd (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40))))
;;    => 4 rem calls in the if
;; (gcd (rem (rem 206 40) (rem 40 (rem 206 40))) (rem (rem 40 (rem 206 40))
;;    (rem (rem 206 40) (rem 40 (rem 206 40)))))
;;    => 7 rem calls in the if 
;;    => 4 rem calls in the final reduction
;; 2
