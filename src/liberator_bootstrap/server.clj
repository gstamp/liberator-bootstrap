(ns liberator-bootstrap.server
  (:require
   [ring.adapter.jetty :as jetty])
  (:use

  ; this code is taken from the liberator examples:
  ; https://github.com/clojure-liberator/liberator/blob/master/examples/clj/examples/server.clj

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
