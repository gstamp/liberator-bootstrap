# liberator-bootstrap

A simple example of how to use the [liberator library](https://github.com/clojure-liberator/liberator.git) in a project.  

## Usage

at the project root, issuing the command:

    lein ring server

will start a local jetty server for you, and the hello-world route
will be available at http://localhost:8080/hello-world

There are three files of interest:
1. server.clj - Tells the ring plugin where the routes are defined, and how to fire up a server.
2. core.clj - Defines the routes in our application. I have defined the simplest possible route, hello-world.
3. project.clj - Includes the necessary dependencies, and also installs the lein-ring plugin, which is how the "lein ring server" magic happens.

## License

Copyright © 2012 Paul Sanwald

Distributed under the Eclipse Public License, the same as Clojure.
