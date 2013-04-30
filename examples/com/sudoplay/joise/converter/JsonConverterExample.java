/*
 * Copyright (C) 2013 Jason Taylor
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sudoplay.joise.converter;

import com.sudoplay.joise.Joise;
import com.sudoplay.joise.module.ModuleAutoCorrect;
import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleBasisFunction.BasisType;
import com.sudoplay.joise.module.ModuleFractal;
import com.sudoplay.joise.module.ModuleFractal.FractalType;

public class JsonConverterExample {

  public static void main(String[] args) {
    JsonConverterExample app = new JsonConverterExample();
    app.run();
  }

  void run() {

    JoiseJSONConverter converter = new JoiseJSONConverter();

    ModuleBasisFunction basis = new ModuleBasisFunction();
    basis.setType(BasisType.GRADIENT);
    basis.setSeed(648);

    ModuleFractal frac = new ModuleFractal();
    frac.setType(FractalType.RIDGEMULTI);
    frac.setAllSourceBasisTypes(BasisType.SIMPLEX);
    frac.setNumOctaves(5);
    frac.setSeed(42);

    frac.overrideSource(0, basis);

    ModuleAutoCorrect auto = new ModuleAutoCorrect();
    auto.setSource(frac);
    auto.calculate();
    auto.setLocked(true);

    double d = auto.get(0.26598, 0.986532);

    String json = converter.toJson(auto.getModuleMap());

    System.out.println(json);

    Joise j = new Joise(converter.fromJson(json));

    System.out.println(d + " == " + j.get(0.26598, 0.986532));

  }

}
