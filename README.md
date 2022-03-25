# lorumipsum

LoremIpsum:  A utility to provide a 'lorem ipsum' text for use in testing.

Based on a Java formulation by Oliver C. Dodd (2010)

## Installation

Download from https://github.com/jsowers34/loremipsum-clj

## Usage

(-main): Provides lorem ipsum paragraphs

    $ java -jar lorumipsum-0.1.0-standalone.jar [args]


## Examples

(-main)

(get-paragraphs 5 true)--- requests 5 paragraphs starting with the classic 'Lorem ...'

(get-paragraphs 3 false) --- requests 3 paragraphs.


## License

Copyright © 2022 J.L.Sowers

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
