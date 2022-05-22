(ns sandre1.letter-encoder)

(defn encode-letter
  "some virtual machine to encrypt messages"
  [s x]
  (let [code (Math/pow (+ x (int (first (char-array s)))) 2)]
    (str "#" (int code))))

(defn encode
  [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\w" (fn [s] (encode-letter s number-of-words)))))

(defn decode-letter
  [x y]
  (let [number (Integer/parseInt (subs x 1))
        letter (char (- (Math/sqrt number) y))]
    (str letter)))

(defn decode
  [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\#\d+" (fn [s] (decode-letter s number-of-words)))))

(comment
  (let [code (encode "super secret")
        dec (decode code)]
    dec)
  (encode "If you want to keep a secret, you must also hide it from yourself.")
  (decode *1)
  (encode-letter "aasd" 4)
  (int (first (char-array "b")))
  (+ 2 2)
  0)