/**
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
 * Copyright 2017 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.openapi.models.responses;

import java.util.Map;

import org.eclipse.microprofile.openapi.models.Constructible;
import org.eclipse.microprofile.openapi.models.Extensible;

/**
 * This interface represents the container for the expected responses of an operation. The container maps a HTTP response code to the expected
 * response.
 *
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md#responses-object">Responses Object</a>
 */
public interface APIResponses extends Constructible, Extensible<APIResponses>, Map<String, APIResponse> {

    public static final String DEFAULT = "default";

    /**
     * Adds an APIResponse in the format of the name as a key and the item as the value to APIResponses map
     * 
     * @param name the name of APIResponse (http status code eventually with wildcard or {@value #DEFAULT})
     * @param apiResponse the APIResponse object to be added to APIResponses map
     * @return APIResponses map with the added ApiResponse instance
     * @deprecated since 1.1, use {@link #addAPIResponse(String, APIResponse)} instead
     **/
    @Deprecated
    default APIResponses addApiResponse(String name, APIResponse apiResponse) {
        return addAPIResponse(name, apiResponse);
    }

    /**
     * Adds an APIResponse in the format of the name as a key and the item as the value to APIResponses map
     * 
     * @param name the name of APIResponse (http status code eventually with wildcard or {@value #DEFAULT})
     * @param apiResponse the APIResponse object to be added to APIResponses map
     * @return APIResponses map with the added ApiResponse instance
     **/
    APIResponses addAPIResponse(String name, APIResponse apiResponse);


    /**
     * Removes the given APIResponse to this APIResponses.
     * 
     * @param name the name of APIResponse that will be removed (http status code eventually with wildcard or {@value #DEFAULT})
     */
    void removeAPIResponse(String name);

    /**
     * Returns a copy map (potentially immutable) of the APIResponses.
     * 
     * @return all responses
     */
    Map<String, APIResponse> getAPIResponses();

    /**
     * Set the APIResponses map to this APIResponses
     * 
     * @param items a map containing all responses. Keys are http statuses code eventually with wildcard or {@value #DEFAULT}.
     */
    void setAPIResponses(Map<String, APIResponse> items);

    /**
     * Check whether a APIResponse is present in the map. This is a convenience method for <code>getAPIResponses().containsKey(name)</code>
     * 
     * @param name the name of APIResponse (http status code eventually with wildcard or {@value #DEFAULT})
     * @return a boolean to indicate if the APIResponse is present or not.
     */
    default boolean hasAPIResponse(String name) {
        return getAPIResponses().containsKey(name);
    }

    /**
     * Returns a APIResponse for a given name. This is a convenience method for <code>getAPIResponses().get(name)</code>
     * 
     * @param name the name of APIResponse (http status code eventually with wildcard or {@value #DEFAULT})
     * @return the corresponding APIResponse or null.
     */
    default APIResponse getAPIResponse(String name) {
        return getAPIResponses().get(name);
    }

    /**
     * In the next version, {@link APIResponses} will no longer extends {@link Map}, this method will no longer be present.
     * Use {@link #getAPIResponse(String)} instead.
     * @deprecated since 1.1
     */
    @Deprecated
    @Override
    APIResponse get(Object key);

    /**
     * In the next version, {@link APIResponses} will no longer extends {@link Map}, this method will no longer be present.
     * Use {@link #hasAPIResponse(String)} instead.
     * @deprecated since 1.1
     */
    @Deprecated
    @Override
    boolean containsKey(Object key);
    
    /**
     * In the next version, {@link APIResponses} will no longer extends {@link Map}, this method will no longer be present.
     * Use {@link #addAPIResponse(String, APIResponse)} instead.
     * @deprecated since 1.1
     */
    @Deprecated
    @Override
    APIResponse put(String key, APIResponse value);

    /**
     * In the next version, {@link APIResponses} will no longer extends {@link Map}, this method will no longer be present.
     * Use {@link #setAPIResponses(Map)} instead.
     * @deprecated since 1.1
     */
    @Deprecated
    @Override
    void putAll(Map<? extends String, ? extends APIResponse> m);

    /**
     * In the next version, {@link APIResponses} will no longer extends {@link Map}, this method will no longer be present.
     * Use {@link #removeAPIResponse(String)} instead.
     * @deprecated since 1.1
     */
    @Deprecated
    @Override
    APIResponse remove(Object key);

    /**
     * Returns the default documentation of responses other than the ones declared for specific HTTP response codes in this instance of ApiResponses.
     * <p>
     * Convenience method that is the same as calling {@link #get(Object)} on the map with {@value #DEFAULT} as value for the key.
     * 
     * @deprecated since 1.1, use @link {@link #getDefaultValue()} instead
     * @return the default documentation of responses
     **/
    @Deprecated 
    default APIResponse getDefault() {
        return getDefaultValue();
    }

    /**
     * Returns the default documentation of responses other than the ones declared for specific HTTP response codes in this instance of ApiResponses.
     * <p>
     * Convenience method that is the same as calling {@link #get(Object)} on the map with {@value #DEFAULT} as value for the key.
     * 
     * @return the default documentation of responses
     **/
    APIResponse getDefaultValue();

    /**
     * Sets the default documentation of responses for this instance of ApiResponses. This will cover all the undeclared responses.
     * <p>
     * Convenience method that is the same as calling {@link #addAPIResponse(String, APIResponse)} with {@value #DEFAULT} as value for the key.
     * 
     * @param defaultValue the default documentation of responses
     */
    void setDefaultValue(APIResponse defaultValue);

    /**
     * Sets the default documentation of responses for this instance of ApiResponses and return this instance of ApiResponses. This will cover all the
     * undeclared responses.
     * <p>
     * Convenience method that is the same as calling {@link #addAPIResponse(String, APIResponse)} with {@value #DEFAULT} as value for the key.
     * 
     * @param defaultValue the default documentation of responses
     * @return this ApiResponses instance
     */

    default APIResponses defaultValue(APIResponse defaultValue) {
        setDefaultValue(defaultValue);
        return this;
    }

}