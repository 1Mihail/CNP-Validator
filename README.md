# CNP-Validator
[ ![Download](https://api.bintray.com/packages/mihailproductions/maven/CNPValidator/images/download.svg) ](https://bintray.com/mihailproductions/maven/CNPValidator/_latestVersion)[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)


Validator for romanian CNP (Cod Numeric Personal - equivalent to SSN).
If the CNP is valid, it also extracts the associated information.
It is one of the most advanced algorithms available.

Sequences like these manage to bypass most of the current algorithms, but not this one.
```
0000000000000
7777777777771
9999999999996
```
Check some examples here: [Emag](https://www.emag.ro/asigurari-rca), [CS](http://www.calculatoare-salarizare.ro/validator-cnp.php)

## Usage
```
String cnpSequence = "xxxxxxxxxxxxx";
CNP cnp = new CNP(context, cnpSequence);
```
#### Methods available
* `isValid()` returns **boolean** - CNP validation status
* `getSex()` returns **String** - 3 possible values: 
>*Masculin* | *Feminin* | *Necunoscut*
* `getBirthdate()` returns **Date** - the year format should be 'yy' because the year prefix for romanian residents/foreigners can not be determined, it can only be estimated.  
Example:
```java
 new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(cnp.getBirthdate())
```
* `getCounty()` returns **String** - the name of the associated county.
* `getRegisterNumber()` returns **String** - the associated register number. Possible values: *"001"* - *"999"*.
* `isRomanianCitizen()` returns **Boolean** - the citizenship status.
* `toString()` returns **String** - the CNP itself.  
For a more in depth example, see the [sample](https://github.com/1Mihail/CNP-Validator/blob/master/sample/src/main/java/mihailproductions/com/cnpvalidatordemo/MainActivity.java).

## Download
```
implementation 'com.mihailproductions:cnp-validator:0.1.2'
```
## Preview
![Preview](https://raw.githubusercontent.com/1Mihail/CNP-Validator/master/preview.jpg)

### License
```
Copyright 2018 Mihail Productions

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
