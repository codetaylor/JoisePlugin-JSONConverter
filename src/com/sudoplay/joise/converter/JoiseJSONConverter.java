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

import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sudoplay.joise.ModuleMap;

public class JoiseJSONConverter {

  private Gson gson;

  public JoiseJSONConverter() {
    this(true);
  }

  public JoiseJSONConverter(boolean prettyPrint) {
    GsonBuilder builder = new GsonBuilder();
    if (prettyPrint) {
      builder.setPrettyPrinting();
    }
    gson = builder.create();
  }

  public String toJson(ModuleMap moduleMap) {
    return gson.toJson(moduleMap);
  }

  public void toJson(ModuleMap moduleMap, Writer writer) {
    gson.toJson(moduleMap, writer);
  }

  public ModuleMap fromJson(String json) {
    return gson.fromJson(json, ModuleMap.class);
  }

  public ModuleMap fromJson(Reader reader) {
    return gson.fromJson(reader, ModuleMap.class);
  }

}
