(defproject tech.ardour/utensil "0.0.1-SNAPSHOT"
  :description "Ardour Tech Utilities and Helpers"
  :url "https://github.com/ArdourTech/utensil"
  :license {:name         "Eclipse Public License - v 1.0"
            :url          "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments     "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.10.3" :scope "provided"]
                 [org.clojure/clojurescript "1.10.741" :scope "provided"]]
  :profiles {:dev  {:dependencies []}
             :test {:dependencies [[lambdaisland/kaocha "1.0.732"]]}}
  :source-paths ["src"]
  :test-paths ["test"]
  :aliases {"test" ["with-profile" "+test" "run" "-m" "kaocha.runner"]}
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :sign-releases false}]])
