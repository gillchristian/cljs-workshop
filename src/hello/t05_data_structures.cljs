(ns hello.t05-data-structures)

;; Clojure provides a rich set of immutable and persistent data structures,
;; which support efficient creation of “modified” versions, by utilizing structural sharing.

;; Collections are represented by abstractions, and there may be one or more concrete implementations.
;; In particular, since “modification” operations yield new collections,
;; the new collection might not have the same concrete type as the source collection,
;; but will have the same logical (interface) type.

;; ## List
;;

;; List is a classic singly linked list data structure. Lisp code itself is made out of lists.
;; Lists support fast append to the end and retrieval of the head (first) element.
'(1 2 3)
(list 1 2 3)
(cons 1 (cons 2 (cons 3 nil)))
(cons 1 '(2 3))

(list? '(1 2 3))

;; (cdr '(1 2 3)) doesnt' work =/
;; (car '(1 2 3)) doesnt' work =/

;; ## Vector
;;

;; Vector is an indexed collection (like JavaScript's Array).
;; Vectors support fast lookup by index and fast append to the end of collection.
[1 2 3]
(vector 1 2 3)
(vector? [1 2 3])

(vector '(1 2 3))
(vec '(1 2 3))

;; ## Map
;;

;; A Map is a collection that maps keys to values.
{:a 1 :b 2 :c 3}
(map? {:a 1})

;; Keys can be arbitrary values
{1 :number
 "1" :string
 :a :keyword
 [1] :vector
 {:a 1} :map}

;; ## Set
;;

;; Sets are collections of unique values.

#{1 2 3 4}

;; #{ '(1) '(1)} throws

;; (set '(1) '(1)) ;; yay !!! (nay :( compile time error)

;; #{1 2 2} throws

(set '(1 1 2 3)) ;; yay !!!

(filter #{3 4 5} (range 10)) ;; (2 5 8)

(set? #{1 2 3})
