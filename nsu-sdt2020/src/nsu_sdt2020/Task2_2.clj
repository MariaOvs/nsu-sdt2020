(ns Task2_2)

<<<<<<< Updated upstream
(def ^:const step 0.01)
=======
(def ^:const step2 0.01)
>>>>>>> Stashed changes

(defn count-trapeze [f start end]
  (do
    ;(println "From" start "; To " end "=>"  (* (/ (+ (f start) (f end)) 2) (- end start)))
    (* (/ (+ (f start) (f end)) 2) (- end start))
  ))

<<<<<<< Updated upstream
(defn create-integral-seq [f]
=======
(defn create-integral-seq [f step]
>>>>>>> Stashed changes
  (iterate #(let [acc (first %) n (second %)]
              [(+ acc (count-trapeze f (* step n) (* step (inc n)))) (inc n)]
              )
           [0 0])
  )

<<<<<<< Updated upstream
(defn integral [f]
  (let [integral-seq (create-integral-seq f)]
=======
(defn integral [f step]
  (let [integral-seq (create-integral-seq f step)]
>>>>>>> Stashed changes
    (fn [x]
      (+ (first (nth integral-seq (int (/ x step))))
         (count-trapeze f (* step (int (/ x step))) x)))
    )
  )

(defn delta [a b]
  (if (>= a b)
    (- a b)
    (- b a)))

(defn print-result [a b]
  (do
<<<<<<< Updated upstream
    (print "      Expected:" a ".   Actual:" b )
    (if (<= (delta a b) 0.01) (println ".    =>  Correct.") (println ".   => Incorrect.")))
=======
    (print "      (Expected:" a ".   Actual:" b )
    (if (<= (delta a b) 0.01) (println ".    =>  Correct.)") (println ".   => Incorrect.)")))
>>>>>>> Stashed changes
  )

(defn -main
  [& args]

<<<<<<< Updated upstream
  (let [x 1]      (time(print-result 1 ((integral (fn [x] (* x 2))) x))))
  (let [x 1]      (time(print-result 1 ((integral (fn [x] (* x 2))) x)))) ; =>  прирост производительности
  (let [x 3]      (print-result 9 ((integral (fn [x] (* x 2))) x)))
  (let [x 10]     (print-result 100 ((integral (fn [x] (* x 2))) x)))

  (let [x 1]      (print-result (/ 1.0 3) ((integral (fn [x] (* x x))) x)))
  (let [x 3]      (print-result 9 ((integral (fn [x] (* x x))) x)))
  (let [x 10]     (print-result (/ 1000.0 3) ((integral (fn [x] (* x x))) x)))

  (let [x 1]      (print-result 5.5 ((integral (fn [x] (+ x 5))) x)))
  (let [x 3]      (print-result 19.5 ((integral (fn [x] (+ x 5))) x)))
  (let [x 10]     (print-result 100 ((integral (fn [x] (+ x 5))) x)))
=======
  (let [x 1]      (time(print-result 1 ((integral (fn [x] (* x 2)) 0.01) x)))) ;происходит прогрев JVM

  (println "Для 100")
  (let [x 100]      (time(print-result 10000 ((integral (fn [x] (* x 2)) 0.01) x))))
  (println "Для 1000")
  (let [x 1000]      (time(print-result 1000000 ((integral (fn [x] (* x 2)) 0.01) x))))
  (let [x 1000]      (time(print-result 1000000 ((integral (fn [x] (* x 2)) 0.01) x)))); =>  прирост производительности
  (println "Для 999")
  (let [x 999]      (time(print-result 998001 ((integral (fn [x] (* x 2)) 0.01) x))))
  (let [x 999]      (time(print-result 998001 ((integral (fn [x] (* x 2)) 0.01) x))))
  (println "Для 1001")
  (let [x 1001]      (time(print-result 1002001 ((integral (fn [x] (* x 2)) 0.01) x))))
  (let [x 1001]      (time(print-result 1002001 ((integral (fn [x] (* x 2)) 0.01) x))))


  (let [x 10]     (print-result 100 ((integral (fn [x] (* x 2)) 0.01) x)))

  (let [x 1]      (print-result (/ 1.0 3) ((integral (fn [x] (* x x)) 0.01) x)))
  (let [x 3]      (print-result 9 ((integral (fn [x] (* x x)) 0.01) x)))
  (let [x 10]     (print-result (/ 1000.0 3) ((integral (fn [x] (* x x)) 0.01) x)))

  (let [x 1]      (print-result 5.5 ((integral (fn [x] (+ x 5)) 0.01) x)))
  (let [x 3]      (print-result 19.5 ((integral (fn [x] (+ x 5)) 0.01) x)))
  (let [x 10]     (print-result 100 ((integral (fn [x] (+ x 5)) 0.01) x)))
>>>>>>> Stashed changes

)
