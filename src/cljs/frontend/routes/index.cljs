(ns frontend.routes.index
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [frontend.state :as f-state]
            [frontend.util :as f-util]))


(def default-svg-color "#848E94")

(defn vk-svg [{:keys [fill] :or {fill default-svg-color}}]
  [:svg {:width "25", :height "15", :view-box "0 0 25 15", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:d "M23.9954 14.9988H21.2581C20.2229 14.9988 19.911 14.152 18.0553 12.2766C16.4336 10.698 15.7486 10.5017 15.3384 10.5017C14.771 10.5017 14.6163 10.6592 14.6163 11.4479V13.9339C14.6163 14.6063 14.4004 15 12.6611 15C10.9737 14.8855 9.33734 14.3678 7.88688 13.4894C6.43642 12.6111 5.21331 11.3973 4.31831 9.94805C2.19321 7.27672 0.71457 4.14143 0 0.791541C0 0.377208 0.155939 0.00164377 0.938033 0.00164377H3.67296C4.37589 0.00164377 4.62899 0.317845 4.90488 1.04838C6.23276 4.99544 8.49868 8.42883 9.41872 8.42883C9.77138 8.42883 9.92492 8.27134 9.92492 7.38331V3.31752C9.80857 1.46271 8.83335 1.30643 8.83335 0.635258C8.84568 0.458186 8.92588 0.292947 9.05691 0.174638C9.18794 0.0563281 9.35947 -0.00573039 9.53507 0.00164377H13.8342C14.422 0.00164377 14.6163 0.297249 14.6163 1.00719V6.49528C14.6163 7.0877 14.8682 7.28396 15.0457 7.28396C15.3984 7.28396 15.6695 7.0877 16.316 6.43591C17.7019 4.7289 18.8342 2.82706 19.6771 0.79033C19.7634 0.545792 19.9265 0.336471 20.1416 0.194293C20.3566 0.0521145 20.6118 -0.0151164 20.8682 0.00285518H23.6044C24.4249 0.00285518 24.5988 0.417188 24.4249 1.0084C23.4297 3.25987 22.1983 5.39706 20.7519 7.38331C20.4568 7.83762 20.3393 8.07386 20.7519 8.60692C21.023 9.02125 21.9826 9.83053 22.6268 10.5998C23.5648 11.5448 24.3433 12.6376 24.9323 13.8345C25.1674 14.6051 24.7763 14.9988 23.9954 14.9988Z", :fill fill}
    [:path {:d "M23.9954 14.9988H21.2581C20.2229 14.9988 19.911 14.152 18.0553 12.2766C16.4336 10.698 15.7486 10.5017 15.3384 10.5017C14.771 10.5017 14.6163 10.6592 14.6163 11.4479V13.9339C14.6163 14.6063 14.4004 15 12.6611 15C10.9737 14.8855 9.33734 14.3678 7.88688 13.4894C6.43642 12.6111 5.21331 11.3973 4.31831 9.94805C2.19321 7.27672 0.71457 4.14143 0 0.791541C0 0.377208 0.155939 0.00164377 0.938033 0.00164377H3.67296C4.37589 0.00164377 4.62899 0.317845 4.90488 1.04838C6.23276 4.99544 8.49868 8.42883 9.41872 8.42883C9.77138 8.42883 9.92492 8.27134 9.92492 7.38331V3.31752C9.80857 1.46271 8.83335 1.30643 8.83335 0.635258C8.84568 0.458186 8.92588 0.292947 9.05691 0.174638C9.18794 0.0563281 9.35947 -0.00573039 9.53507 0.00164377H13.8342C14.422 0.00164377 14.6163 0.297249 14.6163 1.00719V6.49528C14.6163 7.0877 14.8682 7.28396 15.0457 7.28396C15.3984 7.28396 15.6695 7.0877 16.316 6.43591C17.7019 4.7289 18.8342 2.82706 19.6771 0.79033C19.7634 0.545792 19.9265 0.336471 20.1416 0.194293C20.3566 0.0521145 20.6118 -0.0151164 20.8682 0.00285518H23.6044C24.4249 0.00285518 24.5988 0.417188 24.4249 1.0084C23.4297 3.25987 22.1983 5.39706 20.7519 7.38331C20.4568 7.83762 20.3393 8.07386 20.7519 8.60692C21.023 9.02125 21.9826 9.83053 22.6268 10.5998C23.5648 11.5448 24.3433 12.6376 24.9323 13.8345C25.1674 14.6051 24.7763 14.9988 23.9954 14.9988Z", :fill fill}]]])


(defn telegram-svg [{:keys [fill] :or {fill default-svg-color}}]
  [:svg {:width "25", :height "21", :view-box "0 0 25 21", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:d "M23.3125 0.13808L1.16735 8.69123C-0.343973 9.29923 -0.33523 10.1437 0.890063 10.5202L6.57562 12.2966L19.7303 3.98368C20.3524 3.60463 20.9207 3.80854 20.4535 4.22388L9.7956 13.8579H9.7931L9.7956 13.8592L9.40341 19.7289C9.97796 19.7289 10.2315 19.4649 10.5538 19.1534L13.3154 16.4638L19.0596 20.7134C20.1188 21.2977 20.8794 20.9974 21.143 19.7314L24.9138 1.93203C25.2997 0.382027 24.323 -0.31979 23.3125 0.13808Z", :fill fill}]])


(defn search-svg [{:keys [fill] :or {fill default-svg-color}}]
  [:svg {:width "24", :height "25", :view-box "0 0 24 25", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:d "M2.88892 10.111C2.88892 8.19557 3.64985 6.35859 5.0043 5.00417C6.35875 3.64976 8.19578 2.88886 10.1113 2.88886C12.0268 2.88886 13.8638 3.64976 15.2182 5.00417C16.5727 6.35859 17.3336 8.19557 17.3336 10.111C17.3336 12.0264 16.5727 13.8634 15.2182 15.2178C13.8638 16.5722 12.0268 17.3331 10.1113 17.3331C8.19578 17.3331 6.35875 16.5722 5.0043 15.2178C3.64985 13.8634 2.88892 12.0264 2.88892 10.111ZM10.1113 3.18615e-07C8.50973 3.04745e-06 6.93109 0.380427 5.50536 1.10994C4.07963 1.83946 2.84759 2.89721 1.91069 4.19607C0.973792 5.49494 0.358835 6.99777 0.116462 8.58082C-0.125912 10.1639 0.0112317 11.7819 0.516598 13.3015C1.02196 14.8212 1.8811 16.1991 3.02325 17.3217C4.1654 18.4444 5.5579 19.2797 7.08608 19.7588C8.61426 20.238 10.2344 20.3473 11.8131 20.0778C13.3918 19.8082 14.8839 19.1675 16.1665 18.2085L21.5333 24.5765C21.8041 24.8475 22.1716 24.9999 22.5547 25C22.9379 25.0001 23.3054 24.8481 23.5765 24.5772C23.8475 24.3064 23.9999 23.939 24 23.5558C24.0001 23.1726 23.8481 22.8051 23.5772 22.5341L18.2104 16.1675C19.3347 14.6646 20.0184 12.8784 20.1851 11.009C20.3518 9.13949 19.9949 7.26054 19.1542 5.58244C18.3136 3.90434 17.0224 2.49334 15.4253 1.50741C13.8282 0.521477 11.9882 -0.000470776 10.1113 3.18615e-07Z", :fill fill}]])


(defn hamburger-svg [{:keys [fill] :or {fill default-svg-color}}]
  [:svg {:width "24", :height "18", :view-box "0 0 24 18", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:d "M0 16H23.25", :stroke fill, :stroke-width "3"}]
   [:path {:d "M0 9H23.25", :stroke fill, :stroke-width "3"}]
   [:path {:d "M0 2H23.25", :stroke fill, :stroke-width "3"}]])

(defn human-svg [{:keys [fill] :or {fill default-svg-color}}]
  [:svg {:width "30", :height "39", :view-box "0 0 30 39", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:d "M0 39C0 35.0596 1.58035 31.2807 4.3934 28.4944C7.20644 25.7082 11.0218 24.1429 15 24.1429C18.9782 24.1429 22.7936 25.7082 25.6066 28.4944C28.4196 31.2807 30 35.0596 30 39H0ZM15 22.2857C8.78438 22.2857 3.75 17.2993 3.75 11.1429C3.75 4.98643 8.78438 0 15 0C21.2156 0 26.25 4.98643 26.25 11.1429C26.25 17.2993 21.2156 22.2857 15 22.2857Z", :fill fill}]])


(defn task-svg [{:keys [fill] :or {fill default-svg-color}}]
  [:svg {:width "24", :height "25", :vie-wbox "0 0 24 25", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:opacity "0.3", :d "M21.3333 22.2222V9.72222H2.66667V22.2222H21.3333ZM21.3333 2.77778C22.0406 2.77778 22.7189 3.07044 23.2189 3.59137C23.719 4.1123 24 4.81884 24 5.55556V22.2222C24 22.9589 23.719 23.6655 23.2189 24.1864C22.7189 24.7073 22.0406 25 21.3333 25H2.66667C1.95942 25 1.28115 24.7073 0.781048 24.1864C0.280951 23.6655 0 22.9589 0 22.2222V5.55556C0 4.81884 0.280951 4.1123 0.781048 3.59137C1.28115 3.07044 1.95942 2.77778 2.66667 2.77778H4V0H6.66667V2.77778H17.3333V0H20V2.77778H21.3333ZM16.7067 13.9722L10.7867 20.1389L7.21333 16.4167L8.62667 14.9444L10.7867 17.1944L15.2933 12.5L16.7067 13.9722Z", :fill fill}]])


(defn tasks-svg []
  [:svg {:width "23", :height "24", :viewbox "0 0 23 24", :fill "none", :xmlns "http://www.w3.org/2000/svg"}
   [:path {:d "M20.9091 17.4545V7.63636H6.27273V17.4545H20.9091ZM20.9091 2.18182C21.4636 2.18182 21.9955 2.41169 22.3876 2.82086C22.7797 3.23003 23 3.78498 23 4.36364V17.4545C23 18.0332 22.7797 18.5882 22.3876 18.9973C21.9955 19.4065 21.4636 19.6364 20.9091 19.6364H6.27273C5.71818 19.6364 5.18635 19.4065 4.79423 18.9973C4.40211 18.5882 4.18182 18.0332 4.18182 17.4545V4.36364C4.18182 3.78498 4.40211 3.23003 4.79423 2.82086C5.18635 2.41169 5.71818 2.18182 6.27273 2.18182H7.31818V0H9.40909V2.18182H17.7727V0H19.8636V2.18182H20.9091ZM17.2814 10.9745L12.6395 15.8182L9.83773 12.8945L10.9459 11.7382L12.6395 13.5055L16.1732 9.81818L17.2814 10.9745ZM2.09091 21.8182H16.7273V24H2.09091C1.53637 24 1.00453 23.7701 0.612413 23.361C0.220292 22.9518 0 22.3968 0 21.8182V8.72727H2.09091V21.8182Z", :fill "#fff"}]])



(defn menu []
  [:div {:class ["menu"]}
   [:a {:href "#" :class ["menu-item"]} [vk-svg]]
   [:a {:href "#" :class ["menu-item menu-item-telegram"]} [telegram-svg]]
   [:a {:href "#" :class ["menu-item"]} [search-svg]]
   [:a {:href "#" :class ["menu-item menu-item-human"]} [human-svg]]
   [:a {:href "#" :class ["menu-item menu-item-hamburger"]} [hamburger-svg]]])


(defn button [{:keys [alert? logo text]} & children]
  [:a {:class ["button"
               (when alert? "button-alert")
               (when logo "button-with-logo")]
       :href "#"}
   (when logo [:img {:src logo}])
   (when text [:span text])
   children])


(defn header []
  (let [{:keys [width _]} (f-util/use-screen-size)]
    [:header {:class ["header horizontal-block"]}
     [:div.header-left
      [button {:logo "tasks.svg"} "Мероприятия"]]
     [:div.header-right
      (when (> width 480) [button {:alert? true} "Стать добровольцем"])
      (when (> width 840) [menu])]]))

(defn top-banner []
  (let [{:keys [width height]} (f-util/use-screen-size)]
    [:div.top-banner.horizontal-block
     [:div.top-banner-center-block
      [:div.top-banner-first-title "Добровольцы"]
      [:div.top-banner-second-title "Милосердие"]
      (when (> width 1400) [:div.top-banner-third-title "В этом мире есть любовь!"])]
     (when (> width 1400) [:div.top-banner-right-block [:img {:src "/mother-and-child.jpeg"}]])]))


(defn main-info-banner []
  (let [{:keys [width height]} (f-util/use-screen-size)]
    [:div.main-info.horizontal-block
     [:div.main-info-left-block>div.main-info-left-block-article-wrapper
      [:div.main-info-left-block-article
       [:div.main-info-left-block-article-left-block
        [:div.main-info-left-block-article-left-block-title-wrapper
         [:div.main-info-left-block-article-left-block-title "Ищем координатора ремонтной службы"]
         (when (<= width 700) [:div.main-info-left-block-article-right-block])]
        [:div.main-info-left-block-article-left-block-content-outer-wrapper
         [:div.main-info-left-block-article-left-block-content-inner-wrapper
          [:div.main-info-left-block-article-left-block-content
           "Рыбатекст используется дизайнерами, проектировщиками и фронтендерами,
           когда нужно быстро заполнить макеты или прототипы содержимым."]
          [button {:alert? true} "Стать координатором"]]
         (when (and (> width 700) (<= width 1440)) [:div.main-info-left-block-article-right-block])]]
       (when (> width 1440) [:div.main-info-left-block-article-right-block])]]
     [:div.main-info-right-block
      [:div.main-info-right-block-element.main-info-right-block-title
       [:div.main-info-right-block-element-inner-wrapper "Ближайшие события"]]
      (for [i (range 4)]
        [:a.main-info-right-block-element.main-info-right-block-element-story
         [:div.main-info-right-block-element-inner-wrapper
          [:div.main-info-right-block-element-date-container
           [task-svg]
           [:div.main-info-right-block-element-date-text "11 февраля"]]
          [:div.main-info-right-block-element-summary "Радостная Встреча добровольцев и прихожан в Храме РДКБ"]]])]]))



(defn hook-support-warapper []
  (let [{:keys [width _]} (f-util/use-screen-size)]
    [:div.app
     [:f> header]
     [:div.centering-block>div.centering-child
      [:f> top-banner]]
     (when (<= width 480) [:div.centering-block>div.centering-child
                           [:div.horizontal-block {:style {:padding-bottom "2rem"}}
                            [button {:alert? true} "Стать добровольцем"]]])
     [:div.centering-block>div.centering-child
      [:f> main-info-banner]]
     (when (<= width 840) [:<>
                           [menu]
                           [:div.menu-backdrop]])]))




(defn landing-page []
  [:f> hook-support-warapper])
