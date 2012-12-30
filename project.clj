(defproject liberator-bootstrap "0.1.0-SNAPSHOT"
  :description "A simple example of a project set up to use liberator"
  :url "http://localhost:8080/hello-world"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
      [org.clojure/clojure "1.4.0"]
      [compojure "1.0.2"]
      [ring/ring-jetty-adapter "1.1.0"]
      [liberator "0.3.2"]
  ]

  ; The lein-ring plugin allows us to call "lein ring server"
  :plugins [[lein-ring "0.7.5"]]

  ; Tell the lein-ring plugin how to start up a server
  :ring {:handler liberator-bootstrap.server/handler
    :adapter {:port 8080}}
  )
