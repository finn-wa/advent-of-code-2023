(ns aoc.utils)

(require '[clojure.java.io :as io])

(defn read-all-lines [file-path]
  (with-open [reader (io/reader file-path)]
    (doall (line-seq reader))))

(defn read-input
  "Reads lines of a text input file to a list"
  [day filename]
  (read-all-lines (str "src/aoc/day" day "/input/" filename ".txt")))
