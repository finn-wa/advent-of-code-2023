(ns aoc.day01.main 
  (:require [aoc.utils :refer [read-input]]))

; Trebuchet!?

(def input (read-input "01" "main"))

; Part 1

(defn concat-parse-int
  "Takes the digits and converts them to a single integer"
  [digit1 digit2]
  (Integer/parseInt (str digit1 digit2)))

(defn recover-value-part1
  [line]
  (let [digits (re-seq #"\d" line)]
    (concat-parse-int (first digits) (last digits))))

(defn part1
  [lines]
  (reduce + (map recover-value-part1 lines)))

; Part 2

(def translations {"zero" "0"
                   "one" "1"
                   "two" "2"
                   "three" "3"
                   "four" "4"
                   "five" "5"
                   "six" "6"
                   "seven" "7"
                   "eight" "8"
                   "nine" "9"})

(defn translate
  [re-match]
  (let [digit (last re-match)]
    (get translations digit digit)))

(defn recover-value-part2
  "Returns the first and last digits from the string, included spelled out digits"
 [line]
  ;; Use positive lookahead to allow overlapping matches
 (let [digits (re-seq #"(?=(\d|zero|one|two|three|four|five|six|seven|eight|nine))" line)
       first-digit (translate (first digits))
       last-digit (translate (last digits))]
   (println (str line ": " first-digit last-digit))
   (concat-parse-int first-digit last-digit)))

(defn part2
  [lines]
  (reduce + (map recover-value-part2 lines))
)

(part2 input)
