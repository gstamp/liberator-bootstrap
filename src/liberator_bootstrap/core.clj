(ns liberator-bootstrap.core
  (:use [liberator.core :only [defresource]]
  [compojure.core :only [routes ANY routes]]))

(defresource hello-world
  :handle-ok "Hello World!"
  :available-media-types ["text/plain"])

(defn assemble-routes 
  "set up URLs for our compojure resources."
  []
  (->
    (routes
      (ANY "/hello-world" [] hello-world)
      ; define "/" because lein ring server will take us there by default
      (ANY "/" [] hello-world))))
