(ns sicp-clj.exercise1_22)

(defn timed-prime-test
  [n]
  (newline)
  (println n)
  (start-prime-test n (quot (System/currentTimeMillis) 1000)))

(defn start-prime-test
  [n start-time]
  (if (prime? n)
    (report-prime (- (quot (System/currentTimeMillis) 1000) start-time))))

(defn report-prime
  [elapsed-time]
  (println " *** ")
  (println elapsed-time)
  true)

(defn search-for-primes
  [start]
  (let [x start
        primes 0]
    (while (< primes 3) 
      (if (even? x)
        (+ 1 x)
        (do
          (if (timed-prime-test x)
            (+ 1 primes))
          (+ x 2)))))


