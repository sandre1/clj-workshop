(ns sandre1.activity101
  (:use [clojure.repl]))

(def base-co2 382)

(def base-year 2006)

(defn co2-estimate 
 "Function that takes one integer parameter called year and
returns the estimated level of CO2 ppm for that year."  
  [year]
  (let [year-diff (- year base-year)
        estimate (+ base-co2 (* 2 year-diff))]
    estimate))
(comment 
  (co2-estimate 2020)
  (doc co2-estimate))