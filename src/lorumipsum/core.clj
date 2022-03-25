(ns lorumipsum.core
  (:gen-class))

(def ^:private punctuation '[";" "." "?" "!"])

(def ^:private standard '["Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."])

(def ^:private words '["a" "ac" "accumsan" "ad" "adipiscing" "aenean" "aliquam" "aliquet"
	    "amet" "ante" "aptent" "arcu" "at" "auctor" "augue" "bibendum" "blandit" "class" "commodo"
	    "condimentum" "congue" "consectetur" "consequat" "conubia" "convallis" "cras" "cubilia" "cum"
	    "curabitur" "curae" "cursus" "dapibus" "diam" "dictum" "dictumst" "dignissim" "dis" "dolor"
	    "donec" "dui" "duis" "egestas" "eget" "eleifend" "elementum" "elit" "enim" "erat" "eros" "est"
	    "et" "etiam" "eu" "euismod" "facilisi" "facilisis" "fames" "faucibus" "felis" "fermentum"
	    "feugiat" "fringilla" "fusce" "gravida" "habitant" "habitasse" "hac" "hendrerit" "himenaeos"
	    "iaculis" "id" "imperdiet" "in" "inceptos" "integer" "interdum" "ipsum" "justo" "lacinia" "lacus"
	    "laoreet" "lectus" "leo" "libero" "ligula" "litora" "lobortis" "lorem" "luctus" "maecenas"
	    "magna" "magnis" "malesuada" "massa" "mattis" "mauris" "metus" "mi" "molestie" "mollis" "montes"
	    "morbi" "mus" "nam" "nascetur" "natoque" "nec" "neque" "netus" "nibh" "nisi" "nisl" "non"
	    "nostra" "nulla" "nullam" "nunc" "odio" "orci" "ornare" "parturient" "pellentesque" "penatibus"
	    "per" "pharetra" "phasellus" "placerat" "platea" "porta" "porttitor" "posuere" "potenti"
	    "praesent" "pretium" "primis" "proin" "pulvinar" "purus" "quam" "quis" "quisque" "rhoncus"
	    "ridiculus" "risus" "rutrum" "sagittis" "sapien" "scelerisque" "sed" "sem" "semper" "senectus"
	    "sit" "sociis" "sociosqu" "sodales" "sollicitudin" "suscipit" "suspendisse" "taciti" "tellus"
	    "tempor" "tempus" "tincidunt" "torquent" "tortor" "tristique" "turpis" "ullamcorper" "ultrices"
	    "ultricies" "urna" "ut" "varius" "vehicula" "vel" "velit" "venenatis" "vestibulum" "vitae"
	    "vivamus" "viverra" "volutpat" "vulputate"])

(defn get-standard []
  "Return the 'standard' Lorum Ipsum text."
  (apply str standard))

(defn random-word[]
  "Return a random word"
  (get words (rand-int (inc (count words))))
)

(defn random-punctuation []
  "Return a random punctuation mark"
  (get punctuation (rand-int (inc (count punctuation))))
)

(defn get-words [thecount]
  "Return the arg number of words"
  (repeatedly thecount #(random-word))
)

(defn get-sentence-fragment []
  "Return a sentence fragment of 3 to 12 words"
   (clojure.string/join " " (get-words (+ 3 (rand-int 10))))
)

(defn rand-bool []
  "Return true or false randomly"
  (= 0 (rand-int 2))
)

(defn get-sentence []
  "Return a random sentence"
  (declare ^:dynamic s)
  (binding [s '()]
    (if (rand-bool)
      (do
        (set! s (conj s (get-sentence-fragment)))
        (set! s (conj s ",")))
      nil)
    (set! s (conj s (get-sentence-fragment)))
    (set! s (conj s (random-punctuation)))
    (set! s (conj s " "))
    (set! s (clojure.string/join " " s))
    (clojure.string/capitalize (clojure.string/reverse (clojure.string/trim (apply str s))))
    ))

(defn get-sentences [cnt]
  "Return arg number of sentences"
  (declare ^:dynamic s)
  (binding [s '()]
    (loop [ix 0]
      (set! s (conj s (get-sentence)))
      (if (> ix cnt)
        nil
        (recur (inc ix))))
    (set! s (apply str s))))

(defn get-paragraph [useStandard]
  "Return a paragraph. Either the standard phrase (if arg is true) or a 1 to 4 sentences"
  (if useStandard
    (get-standard)
    (get-sentences (+ 1 (rand-int 4)))
    ))

(defn get-paragraphs [cnt useStandard]
  "Return 1st arg number of paragraphs; if 2nd arg is true, start with the standard phrase"
  (declare ^:dynamic s)
  (binding [s '()]
    (loop [ix 0]
      (set! s  (conj s (get-paragraph false)))
      (if (= ix cnt)
        nil
        (recur (inc ix)))
      )
    (if useStandard
      (set! s (conj s (get-paragraph true)))
      (set! s (conj s (get-paragraph false))))
    (set! s (apply str s))
    s
    ))

(defn -main
  "Get a 5 paragraph 'Lorem Ipsum"
  [& args]
  (get-paragraphs 5 true)
)

