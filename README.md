##JoisePlugin-JSONConverter
Convert Joise module chains to and from Json.

##Dependencies
This code assumes you have the following libs on your classpath:
* [Joise](https://github.com/codetaylor/Joise)
* [Gson](https://code.google.com/p/google-gson/)

##Example
###Convert To JSON
```java
// create a Joise module chain
ModuleBasisFunction basis = new ModuleBasisFunction();
basis.setType(BasisType.GRADIENT);
basis.setSeed(648);

ModuleAutoCorrect auto = new ModuleAutoCorrect();
auto.setSource(basis);
auto.calculate();

// create a converter instance and convert to TML
JoiseJSONConverter converter = new JoiseJSONConverter();
String json = converter.toJson(auto.getModuleMap());
```

```
{
  "func_1": {
    "module": "ModuleBasisFunction",
    "basis": "gradient",
    "interpolation": "quintic",
    "seed": "648"
  },
  "func_2": {
    "module": "ModuleAutoCorrect",
    "low": "0.0",
    "high": "1.0",
    "samples": "100",
    "sampleScale": "1.0",
    "locked": "false",
    "source": "func_1"
  }
}
```
###Convert From JSON
```
// convert from Json to a Joise instance
Joise j = new Joise(converter.fromJson(json));
```
##License

Copyright (C) 2013 Jason Taylor. Released as open-source under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
