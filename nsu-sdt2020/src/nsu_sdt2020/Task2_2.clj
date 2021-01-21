(ns Task2_2)

(defn count-trapeze [f start end]
  (do
    ;(println "From" start "; To " end "=>"  (* (/ (+ (f start) (f end)) 2) (- end start)))
    (* (/ (+ (f start) (f end)) 2) (- end start))
    ))

(defn create-integral-seq [f step]
  (iterate #(let [acc (first %) n (second %)]
              [(+ acc (count-trapeze f (* step n) (* step (inc n)))) (inc n)]
              )
           [0 0])
  )

(defn delta [a b]
  (if (>= a b)
    (- a b)
    (- b a)))

(defn print-result [a b]
  (do
    (print "---> (Expected:" a ".   Actual:" b)
    (if (<= (delta a b) 0.01) (println ".    =>  Correct.)") (println ".   => Incorrect.)")))
  )

(defn get-integrator [f step]
  (let [integral-seq (create-integral-seq f step)]
    (fn [x]
      (+ (first (nth integral-seq (int (/ x step))))
         (count-trapeze f (* step (int (/ x step))) x)))
    ))

(defn -main
  [& args]
  (println " Происходит прогрев JVM")
  (let [do-int (get-integrator (fn [x] (+ x 5)) 0.01)]
    (time(print-result 100 (do-int 10)))
    )

  (println "\n" "Интегрирование")
  (let [do-int (get-integrator (fn [x] (* x 2)) 0.01)]
    (time(print-result 1000000 (do-int 1000)))
    (time(print-result 998001 (do-int 999)))
    (time(print-result 1002001 (do-int 1001)))
    )

  )
