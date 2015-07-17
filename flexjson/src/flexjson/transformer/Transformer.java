/**
 * Copyright 2007 Charlie Hubbard and Brandon Goodin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package flexjson.transformer;

/**
 * Transformers are used to alter the values written to a Flexjson stream.
 * This allows you to modify your data for use with HTML, security like stripping
 * out &lt;script&gt; tags, or rendering HTML from simple markups like markdown or other
 * technologies.  Use {@link JSONSerializer#transform} to register a Transformer to with
 * a JSONSerializer.
 */
public interface Transformer {

    public void transform(Object object);

}
