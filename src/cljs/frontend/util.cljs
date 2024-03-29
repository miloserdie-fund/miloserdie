(ns frontend.util
  (:require
    [cljs.pprint]
    ;; [clojure.pprint]
    [frontend.state :as sf-state]
    [re-frame.core :as re-frame]
    ["react" :as react]))


;; Application wide properties.
(def backend-host-config {:host "localhost" :port 7171})


(defn valid?
  "Simple validator. Checks in [k v] v is a string and not empty."
  [[_ v]]
  (and (string? v) (seq v)))


(defn save!
  "Fetches an event value and swaps the value of given atom a's key k to this value."
  [a k]
  #(swap! a assoc k (-> % .-target .-value)))


(defn input
  "Input field component for e.g. First name, Last name, Email address and Password."
  [label k type state]
  [:div.flex.flex-wrap.gap-2.items-center.mt-1
   [:label {:htmlFor (name k) :className "login-label"} label]
   [:div
    [:input {:type "text"
             :id (name k)
             :name (name k)
             :className "login-input"
             :placeholder (name k)
             :value (k @state)
             :on-change (save! state k)
             :required true}]]])


(defn get-base-url
  []
  (let [host (:host backend-host-config)
        port (:port backend-host-config)
        url (str "http://" host ":" port)]
    url))


(defn debug-panel
  "Debug panel - you can use this panel in any view to show some page specific debug data."
  [data]
  (let [debug @(re-frame/subscribe [::sf-state/debug])]
    #_(js/console.log (str "ENTER debug-panel, debug: " debug))
    (if debug
      [:div.sf-debug-panel
       [:hr.sf-debug-panel.hr]
       [:h3.sf-debug-panel.header "DEBUG-PANEL"]
       [:pre.sf-debug-panel.body (with-out-str (cljs.pprint/pprint data))]])))


(defn clog
  "Javascript console logger helper."
  ([msg] (clog msg nil))
  ([msg data]
   (let [buf (if data
               (str msg ": " data)
               msg)]
     (js/console.log buf))))


(defn error-message
  [title msg]
  [:<>
   [:div.bg-red-100.border.border-red-400.text-red-700.px-4.py-3.rounded.relative
    {:role "alert"}
    [:strong.font-bold.mr-2 title]
    [:span.block.sm:inline msg]]])


(defn myParseInt
  [s]
  (js/parseInt s 10))


;; React Hooks

(defn use-screen-size []
      (let [[screen-size set-screen-size] (react/useState {:width (.-innerWidth js/window)
                                                           :height (.-innerHeight js/window)})]
               (react/useEffect (fn [event])
                                           (let [handle-resize (fn [event] (set-screen-size {:width (.-innerWidth js/window)}
                                                                                                      :height (.-innerHeight js/window)))])
                                                (js/window.addEventListener "resize" handle-resize)
                                                (fn [])
                                                    (js/window.removeEventListener "resize" handle-resize)
                                       #js [])
               screen-size))
