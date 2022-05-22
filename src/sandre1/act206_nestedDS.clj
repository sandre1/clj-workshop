(ns sandre1.act206-nestedDS
  (:require [clojure.pprint :as pp]))
(def gemstone-db {
    :ruby {
      :name "Ruby"
      :stock 120
      :sales [1990 3644 6376 4918 7882 6747 7495 8573 5097 1712]
      :properties {
        :dispersion 0.018
        :hardness 9.0
        :refractive-index [1.77 1.78]
        :color "Red"
      }
    }
   :diamond {
      :name "Diamond"
      :stock 10
      :sales [8295 329 5960 6118 4189 3436 9833 8870 9700 7182 7061 1579]
      :properties {
        :dispersion 0.044
        :hardness 10
        :refractive-index [2.417 2.419]
        :color "Typically yellow, brown or gray to colorless"
      }
    }
    :moissanite {
      :name "Moissanite"
      :stock 45
      :sales [7761 3220]
      :properties {
        :dispersion 0.104
        :hardness 9.5
        :refractive-index [2.65 2.69]
        :color "Colorless, green, yellow"
      }
    }
  }
)

(get-in gemstone-db [:ruby :stock])

(defn durability
  [db gemstone]
  (get-in db [gemstone :properties :hardness]))

(durability gemstone-db :moissanite)

(assoc (gemstone-db :ruby) :properties {:color "Near colorless through pink through
all shades of red to a deep crimson."})
(update (:ruby gemstone-db) :properties into {:color "Near colorless through pink through
all shades of red to a deep crimson."})
(assoc-in gemstone-db [:ruby :properties :color] "Near colorless through pink through
all shades of red to a deep crimson.")
(pp/pprint *1)

(defn change-color
  [db gemstone new-color]
  (assoc-in db [gemstone :properties :color] new-color))

(change-color gemstone-db :moissanite "cacaniu in dungi")

(update-in gemstone-db [:diamond :stock] dec)
(update-in gemstone-db [:diamond :sales] conj 999)

(defn sell
  [db gemstone client-id]
  (let [clients-updated-db (update-in db [gemstone :sales] conj client-id)]
    (update-in clients-updated-db [gemstone :stock] dec)))

(sell gemstone-db :diamond 666)
(sell gemstone-db :moissanite 123)

(set! *print-level* nil)
