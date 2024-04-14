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

import org.openapitools.client.ApiException
import org.openapitools.client.Pair
import java.net.URI
import java.util.Optional
import java.util.function.Supplier
import javax.annotation.Generated

@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:33.796785+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class HttpBearerAuth(private val scheme: String?) : Authentication {
    private var tokenSupplier: Supplier<String>? = null
    var bearerToken: String
        /**
         * Gets the token, which together with the scheme, will be sent as the value of the Authorization header.
         *
         * @return The bearer token
         */
        get() = tokenSupplier!!.get()
        /**
         * Sets the token, which together with the scheme, will be sent as the value of the Authorization header.
         *
         * @param bearerToken The bearer token to send in the Authorization header
         */
        set(bearerToken) {
            tokenSupplier = Supplier { bearerToken }
        }

    /**
     * Sets the supplier of tokens, which together with the scheme, will be sent as the value of the Authorization header.
     *
     * @param tokenSupplier The supplier of bearer tokens to send in the Authorization header
     */
    fun setBearerToken(tokenSupplier: Supplier<String>?) {
        this.tokenSupplier = tokenSupplier
    }

    @Throws(ApiException::class)
    override fun applyToParams(queryParams: MutableList<Pair?>, headerParams: MutableMap<String?, String?>, cookieParams: MutableMap<String?, String?>,
                               payload: String?, method: String?, uri: URI?) {
        val bearerToken = Optional.ofNullable(tokenSupplier).map { obj: Supplier<String>? -> obj!!.get() }.orElse(null)
                ?: return
        headerParams["Authorization"] = (if (scheme != null) upperCaseBearer(scheme) + " " else "") + bearerToken
    }

    companion object {
        private fun upperCaseBearer(scheme: String): String {
            return if ("bearer".equals(scheme, ignoreCase = true)) "Bearer" else scheme
        }
    }
}
