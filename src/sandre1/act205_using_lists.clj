(ns sandre1.act205-using-lists)

(def my-todo (list "Feed the cat" "Clean the room" "See a movie"))

(def language {:name "Clojure" :creator "Rich Hikey" :platforms ["Java" "Javascript" ".NET"]})

(comment
  (+ 1 1)
  (count language)
  (empty? language)
  (seq language)
  (cons "Learn some clojure" my-todo)
  (conj my-todo "drink water")
  (first my-todo)
  (rest my-todo)
  (nth my-todo 0)
  (into [1 2 3 4] [1 5 6 7])
  (into #{1 2 3} [1 59 3])
  (into #{} [4 4 5 5 5 5  3])
  (into {} [[:name "amdrei"]])
  (conj language {:created 2007})
  (conj *1 {:created 2005})
  0) 