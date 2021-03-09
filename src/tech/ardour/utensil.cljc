(ns tech.ardour.utensil
  #?(:clj
     (:import
       (java.util UUID)
       (java.time Instant))))

(defn update-some
  "'Updates' a value in an associative structure, where `k` is a key and `f` is a function that will take the old value
  and return the new value. Returns a new structure. If the value of the key fails the `some?` predicate, `f` will not
  be invoked and the map will not be updated"
  [m k f]
  (let [v (get m k)]
    (if (some? v)
      (assoc m k (f v))
      m)))

(defn assoc-some
  "assoc[iate]-some. When applied to a map `m`, returns a new map of the same (hashed/sorted) type, that contains the
  mapping of key(s) to some val(s). Val(s) that fail the `some?` predicate will be excluded."
  ([m k v]
   (if (some? v)
     (assoc m k v)
     m))
  ([m k v & kvs]
   (let [ret (assoc-some m k v)]
     (if (and kvs (next kvs))
       (recur ret (first kvs) (second kvs) (nnext kvs))
       ret))))

(defn epoch-millis
  "Returns the number of milliseconds since the Unix Epoch"
  []
  #?(:clj  (-> (Instant/now)
               (.toEpochMilli))
     :cljs (.getTime ^js (js/Date.))))

(defn uuid
  "Generate a v4 (random) UUID. Uses default JVM or ClojureScript implementation."
  []
  #?(:clj  (UUID/randomUUID)
     :cljs (random-uuid)))
