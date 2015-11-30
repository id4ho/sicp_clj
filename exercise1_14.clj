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
  [amount types-of-coins depth]
  (loop [i depth]
    (if (> i 0)
      (do (print "  ")
          (recur (dec i)))))
  (print "-> (cc amount:")
  (print amount)
  (print " types-of-coins:")
  (print types-of-coins)
  (print ")\n")

  (cond
    (= types-of-coins 0) 0
    (= amount 0) 1
    (> amount 0)
      (+ (cc (- amount (coins types-of-coins)) types-of-coins (+ depth 1))
         (cc amount (- types-of-coins 1) (+ depth 1)))
    :else 0))

(defn count-change
  [amount]
  (cc amount 5 0))

(count-change 11)

;; why does this not work when i use let for the amount less the largest
;; coin?? (defn also doesn't work)

;; Stack trace that the book asked for
;-> (cc amount:11 types-of-coins:5)
;  -> (cc amount:-39 types-of-coins:5)
;  -> (cc amount:11 types-of-coins:4)
;    -> (cc amount:-14 types-of-coins:4)
;    -> (cc amount:11 types-of-coins:3)
;      -> (cc amount:1 types-of-coins:3)
;        -> (cc amount:-9 types-of-coins:3)
;        -> (cc amount:1 types-of-coins:2)
;          -> (cc amount:-4 types-of-coins:2)
;          -> (cc amount:1 types-of-coins:1)
;            -> (cc amount:0 types-of-coins:1)
;            -> (cc amount:1 types-of-coins:0)
;      -> (cc amount:11 types-of-coins:2)
;        -> (cc amount:6 types-of-coins:2)
;          -> (cc amount:1 types-of-coins:2)
;            -> (cc amount:-4 types-of-coins:2)
;            -> (cc amount:1 types-of-coins:1)
;              -> (cc amount:0 types-of-coins:1)
;              -> (cc amount:1 types-of-coins:0)
;          -> (cc amount:6 types-of-coins:1)
;            -> (cc amount:5 types-of-coins:1)
;              -> (cc amount:4 types-of-coins:1)
;                -> (cc amount:3 types-of-coins:1)
;                  -> (cc amount:2 types-of-coins:1)
;                    -> (cc amount:1 types-of-coins:1)
;                      -> (cc amount:0 types-of-coins:1)
;                      -> (cc amount:1 types-of-coins:0)
;                    -> (cc amount:2 types-of-coins:0)
;                  -> (cc amount:3 types-of-coins:0)
;                -> (cc amount:4 types-of-coins:0)
;              -> (cc amount:5 types-of-coins:0)
;            -> (cc amount:6 types-of-coins:0)
;        -> (cc amount:11 types-of-coins:1)
;          -> (cc amount:10 types-of-coins:1)
;            -> (cc amount:9 types-of-coins:1)
;              -> (cc amount:8 types-of-coins:1)
;                -> (cc amount:7 types-of-coins:1)
;                  -> (cc amount:6 types-of-coins:1)
;                    -> (cc amount:5 types-of-coins:1)
;                      -> (cc amount:4 types-of-coins:1)
;                        -> (cc amount:3 types-of-coins:1)
;                          -> (cc amount:2 types-of-coins:1)
;                            -> (cc amount:1 types-of-coins:1)
;                              -> (cc amount:0 types-of-coins:1)
;                              -> (cc amount:1 types-of-coins:0)
;                            -> (cc amount:2 types-of-coins:0)
;                          -> (cc amount:3 types-of-coins:0)
;                        -> (cc amount:4 types-of-coins:0)
;                      -> (cc amount:5 types-of-coins:0)
;                    -> (cc amount:6 types-of-coins:0)
;                  -> (cc amount:7 types-of-coins:0)
;                -> (cc amount:8 types-of-coins:0)
;              -> (cc amount:9 types-of-coins:0)
;            -> (cc amount:10 types-of-coins:0)
;          -> (cc amount:11 types-of-coins:0)
