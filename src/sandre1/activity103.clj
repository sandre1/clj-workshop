(ns sandre1.activity103
  (:use [clojure.repl]))

(defn meditate
  "Calmness level indicator"
  [calmness-level s]
  (println "Clojure Meditate v2.0")
  (let [punch-line ", i tell ya!"
        echo (str s punch-line)]
    (if (< calmness-level 5) (clojure.string/upper-case echo)
    (if (<= 5 calmness-level 9) (clojure.string/capitalize echo)
        (if (<= calmness-level 10) (clojure.string/reverse echo))))))

(defn meditate2
  "Calmness level indicator - using cond"
  [calmness-level s]
  (println "Clojure Meditate v2.0.1")
  (let [punch-line ", i tell ya!"
        echo (str s punch-line)]
    (cond
      (< calmness-level 5) (clojure.string/upper-case echo)
      (<= 5 calmness-level 9) (clojure.string/capitalize echo)
      (<= calmness-level 10) (clojure.string/reverse echo)
      :else nil)))

(comment 
  (meditate 10 "testing1124")
  (meditate2 2 "blah")
  (doc clojure.string/capitalize)
  )