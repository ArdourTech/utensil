(ns tech.ardour.utensil)

(defn update-some
  "Updates the map value at key k using function f"
  [m k f]
  (let [v (get m k)]
    (if (some? v)
      (assoc m k (f v))
      m)))

(defn assoc-some
  ([m k v]
   (if (some? v)
     (assoc m k v)
     m))
  ([m k v & kvs]
   (let [ret (assoc-some m k v)]
     (if (and kvs (next kvs))
       (recur ret (first kvs) (second kvs) (nnext kvs))
       ret))))
