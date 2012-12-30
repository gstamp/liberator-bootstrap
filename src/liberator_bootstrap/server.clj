(ns liberator-bootstrap.server
  (:require
   [ring.adapter.jetty :as jetty])
  (:use

  ; This is the part where we tell the server where our routes are defined
   [liberator-bootstrap.core :only [assemble-routes]]

   [ring.middleware.multipart-params :only [wrap-multipart-params]]
   [ring.util.response :only [header]]
   [compojure.handler :only [api]]))

(defn create-handler []
  (fn [request]
    (
     (->
      (assemble-routes)
      api
      wrap-multipart-params)
     request)))

(def handler (create-handler))

(defn start [options]
  (jetty/run-jetty
   (fn [request]
     ((create-handler) request))
   (assoc options :join? false)))

(defn -main
  ([port]
     (start {:port (Integer/parseInt port)}))
  ([]
     (-main "8000")))

