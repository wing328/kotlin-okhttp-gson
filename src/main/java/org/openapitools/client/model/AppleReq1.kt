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
package org.openapitools.client.model

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.openapitools.client.JSON
import java.io.IOException
import java.util.Objects
import javax.annotation.Generated

/**
 * AppleReq
 */
@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:37.248933300+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class AppleReq {
    /**
     * Get cultivar
     * @return cultivar
     */
    @get:Nonnull
    @SerializedName(SERIALIZED_NAME_CULTIVAR)
    var cultivar: String? = null

    /**
     * Get mealy
     * @return mealy
     */
    @SerializedName(SERIALIZED_NAME_MEALY)
    var mealy: Boolean? = null
    fun cultivar(cultivar: String?): AppleReq {
        this.cultivar = cultivar
        return this
    }

    fun mealy(mealy: Boolean?): AppleReq {
        this.mealy = mealy
        return this
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val appleReq = o as AppleReq
        return cultivar == appleReq.cultivar && mealy == appleReq.mealy
    }

    override fun hashCode(): Int {
        return Objects.hash(cultivar, mealy)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class AppleReq {\n")
        sb.append("    cultivar: ").append(toIndentedString(cultivar)).append("\n")
        sb.append("    mealy: ").append(toIndentedString(mealy)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }

    class CustomTypeAdapterFactory : TypeAdapterFactory {
        override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
            if (!AppleReq::class.java.isAssignableFrom(type.rawType)) {
                return null // this class only serializes 'AppleReq' and its subtypes
            }
            val elementAdapter = gson.getAdapter(JsonElement::class.java)
            val thisAdapter = gson.getDelegateAdapter(this, TypeToken.get(AppleReq::class.java))
            return object : TypeAdapter<AppleReq>() {
                @Throws(IOException::class)
                override fun write(out: JsonWriter, value: AppleReq) {
                    val obj = thisAdapter.toJsonTree(value).getAsJsonObject()
                    elementAdapter.write(out, obj)
                }

                @Throws(IOException::class)
                override fun read(`in`: JsonReader): AppleReq {
                    val jsonElement = elementAdapter.read(`in`)
                    validateJsonElement(jsonElement)
                    return thisAdapter.fromJsonTree(jsonElement)
                }
            }.nullSafe() as TypeAdapter<T>
        }
    }

    /**
     * Convert an instance of AppleReq to an JSON string
     *
     * @return JSON string
     */
    fun toJson(): String {
        return JSON.getGson().toJson(this)
    }

    companion object {
        const val SERIALIZED_NAME_CULTIVAR = "cultivar"
        const val SERIALIZED_NAME_MEALY = "mealy"
        var openapiFields: HashSet<String>? = null
        var openapiRequiredFields: HashSet<String>? = null

        init {
            // a set of all properties/fields (JSON key names)
            openapiFields = HashSet()
            openapiFields!!.add("cultivar")
            openapiFields!!.add("mealy")

            // a set of required properties/fields (JSON key names)
            openapiRequiredFields = HashSet()
            openapiRequiredFields!!.add("cultivar")
        }

        /**
         * Validates the JSON Element and throws an exception if issues found
         *
         * @param jsonElement JSON Element
         * @throws IOException if the JSON Element is invalid with respect to AppleReq
         */
        @Throws(IOException::class)
        fun validateJsonElement(jsonElement: JsonElement?) {
            if (jsonElement == null) {
                require(openapiRequiredFields!!.isEmpty()) {  // has required fields but JSON element is null
                    String.format("The required field(s) %s in AppleReq is not found in the empty JSON string", openapiRequiredFields.toString())
                }
            }
            val entries = jsonElement!!.getAsJsonObject().entrySet()
            // check to see if the JSON string contains additional fields
            for ((key) in entries) {
                require(openapiFields!!.contains(key)) { String.format("The field `%s` in the JSON string is not defined in the `AppleReq` properties. JSON: %s", key, jsonElement.toString()) }
            }

            // check to make sure all required properties/fields are present in the JSON string
            for (requiredField in openapiRequiredFields!!) {
                requireNotNull(jsonElement.getAsJsonObject()[requiredField]) { String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()) }
            }
            val jsonObj = jsonElement.getAsJsonObject()
            require(jsonObj["cultivar"].isJsonPrimitive) { String.format("Expected the field `cultivar` to be a primitive type in the JSON string but got `%s`", jsonObj["cultivar"].toString()) }
        }

        /**
         * Create an instance of AppleReq given an JSON string
         *
         * @param jsonString JSON string
         * @return An instance of AppleReq
         * @throws IOException if the JSON string is invalid with respect to AppleReq
         */
        @Throws(IOException::class)
        fun fromJson(jsonString: String?): AppleReq {
            return JSON.getGson().fromJson(jsonString, AppleReq::class.java)
        }
    }
}
