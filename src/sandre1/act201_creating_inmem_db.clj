(ns sandre1.act201-creating-inmem-db)

(def memory-db (atom {}))
(defn read-db [] @memory-db)
(defn write-db [new-db] (reset! memory-db new-db))

(defn create-table
  [table-name]
  (let [db (read-db)]
    (write-db (assoc db table-name {:data [] :indexes {}}))))

(defn drop-table
  [table-name]
  (let [db (read-db)]
    (write-db (dissoc db table-name))))

(defn insert
  [table-name record id-key]
  (let [db (read-db)
        new-db (update-in db [table-name :data] conj record)
        index (- (count (get-in new-db [table-name :data])) 1)]
    (write-db (update-in new-db [table-name :indexes id-key] assoc (id-key record) index))))

(defn select-*
  [table-name]
  (get-in (read-db) [table-name :data]))

#_(defn select-*-where
  [table-name field field-value]
  (let [db (read-db)
        t (table-name db)
        ])
  )

(select-* :fruits)
(create-table :clients)
(create-table :fruits)
(read-db)
(let [db (read-db)
      data (get-in db [:fruits :indexes :name])]
  data)
(drop-table :clients)
(insert :fruits {:name "coacaze" :stock 20} :name)


(comment 
  (create-table :clients)
  (create-table :fruits)
  (read-db)
  0)
