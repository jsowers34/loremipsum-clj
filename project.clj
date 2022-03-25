(defproject lorumipsum "0.1.0-SNAPSHOT"
  :description "Lorem Ipsum: A utility to provide a 'Lorum ipsum... string."
  :url "http://192.168.1.23:7070/Lorem"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :mailing-list {:name "Joseph.L.Sowers@gmail.com"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :plugins [[lein-codox "0.10.8"]]
  :main ^:skip-aot lorumipsum.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
