(ns sicp-clj.exercise1_14)

(defn coins
  [num]
  (cond
    (= num 5) 50
    (= num 4) 25
    (= num 3) 10
    (= num 2) 5
    :else 1))

(defn cc
  [amount types-of-coins]
  (cond
    (= types-of-coins 0) 0
    (= amount 0) 1
    (> amount 0)
      (+ (cc (- amount (coins types-of-coins)) types-of-coins)
         (cc amount (- types-of-coins 1)))
    :else 0))

(defn count-change
  [amount]
  (cc amount 5))

(count-change 100)

;; why does this not work when i use let for the amount less the largest coin??

