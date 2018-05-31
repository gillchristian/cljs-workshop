(ns hello.timer
  (:require [reagent.core :as r]
            [goog.dom :as gdom]))

(def timer (r/atom (js/Date.)))

(defonce ticker (js/setInterval #(reset! timer (js/Date.)) 1000))

(def color (r/atom "red"))

(defn timer-comp []
  [:div 
   {:style {:color @color}} 
   (concat "the time is: " (.toLocaleTimeString @timer))])

(defn timer-compo-with-state []
  )

;; (defn handle-change [event] (reset! color (.. event -target -value)))


(defn input []
  [:input 
   {:value @color
    :on-change #(reset! color (.. % -target -value))}])

(defn app []
  [:div
   (timer-comp)
   (input)])
   

(r/render [app] (gdom/getElement "app-root"))
