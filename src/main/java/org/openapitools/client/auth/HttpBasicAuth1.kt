/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints,
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.client.auth

import okhttp3.Credentials.basic
import org.openapitools.client.ApiException
import org.openapitools.client.Pair
import java.net.URI

class HttpBasicAuth : Authentication {
    var username: String? = null
    var password: String? = null
    @Throws(ApiException::class)
    override fun applyToParams(queryParams: MutableList<Pair?>, headerParams: MutableMap<String?, String?>, cookieParams: MutableMap<String?, String?>,
                               payload: String?, method: String?, uri: URI?) {
        if (username == null && password == null) {
            return
        }
        headerParams["Authorization"] = basic(
                (if (username == null) "" else username)!!,
                (if (password == null) "" else password)!!)
    }
}
