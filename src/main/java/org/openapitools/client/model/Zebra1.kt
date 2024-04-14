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
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.openapitools.client.JSON
import java.io.IOException
import java.util.Objects
import javax.annotation.Generated

/**
 * Zebra
 */
@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:33.796785+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class Zebra {
    /**
     * Gets or Sets type
     */
    @JsonAdapter(TypeEnum.Adapter::class)
    enum class TypeEnum(val value: String) {
        PLAINS("plains"),
        MOUNTAIN("mountain"),
        GREVYS("grevys");

        override fun toString(): String {
            return value.toString()
        }

        class Adapter : TypeAdapter<TypeEnum>() {
            @Throws(IOException::class)
            override fun write(jsonWriter: JsonWriter, enumeration: TypeEnum) {
                jsonWriter.value(enumeration.value)
            }

            @Throws(IOException::class)
            override fun read(jsonReader: JsonReader): TypeEnum {
                val value = jsonReader.nextString()
                return fromValue(value)
            }
        }

        companion object {
            fun fromValue(value: String): TypeEnum {
                for (b in entries) {
                    if (b.value == value) {
                        return b
                    }
                }
                throw IllegalArgumentException("Unexpected value '$value'")
            }

            @Throws(IOException::class)
            fun validateJsonElement(jsonElement: JsonElement) {
                val value = jsonElement.asString
                fromValue(value)
            }
        }
    }

    /**
     * Get type
     * @return type
     */
    @SerializedName(SERIALIZED_NAME_TYPE)
    var type: TypeEnum? = null

    /**
     * Get className
     * @return className
     */
    @get:Nonnull
    @SerializedName(SERIALIZED_NAME_CLASS_NAME)
    var className: String? = null
    fun type(type: TypeEnum?): Zebra {
        this.type = type
        return this
    }

    fun className(className: String?): Zebra {
        this.className = className
        return this
    }

    /**
     * A container for additional, undeclared properties.
     * This is a holder for any undeclared properties as specified with
     * the 'additionalProperties' keyword in the OAS document.
     */
    private var additionalProperties: MutableMap<String, Any>? = null

    /**
     * Set the additional (undeclared) property with the specified name and value.
     * If the property does not already exist, create it otherwise replace it.
     *
     * @param key name of the property
     * @param value value of the property
     * @return the Zebra instance itself
     */
    fun putAdditionalProperty(key: String, value: Any): Zebra {
        if (additionalProperties == null) {
            additionalProperties = HashMap()
        }
        additionalProperties!![key] = value
        return this
    }

    /**
     * Return the additional (undeclared) property.
     *
     * @return a map of objects
     */
    fun getAdditionalProperties(): Map<String, Any>? {
        return additionalProperties
    }

    /**
     * Return the additional (undeclared) property with the specified name.
     *
     * @param key name of the property
     * @return an object
     */
    fun getAdditionalProperty(key: String): Any? {
        return if (additionalProperties == null) {
            null
        } else additionalProperties!![key]
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val zebra = o as Zebra
        return type == zebra.type && className == zebra.className && additionalProperties == zebra.additionalProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(type, className, additionalProperties)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Zebra {\n")
        sb.append("    type: ").append(toIndentedString(type)).append("\n")
        sb.append("    className: ").append(toIndentedString(className)).append("\n")
        sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n")
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
            if (!Zebra::class.java.isAssignableFrom(type.rawType)) {
                return null // this class only serializes 'Zebra' and its subtypes
            }
            val elementAdapter = gson.getAdapter(JsonElement::class.java)
            val thisAdapter = gson.getDelegateAdapter(this, TypeToken.get(Zebra::class.java))
            return object : TypeAdapter<Zebra>() {
                @Throws(IOException::class)
                override fun write(out: JsonWriter, value: Zebra) {
                    val obj = thisAdapter.toJsonTree(value).getAsJsonObject()
                    obj.remove("additionalProperties")
                    // serialize additional properties
                    if (value.getAdditionalProperties() != null) {
                        for ((key, value1) in value.getAdditionalProperties()!!) {
                            if (value1 is String) obj.addProperty(key, value1) else if (value1 is Number) obj.addProperty(key, value1) else if (value1 is Boolean) obj.addProperty(key, value1) else if (value1 is Char) obj.addProperty(key, value1) else {
                                val jsonElement = gson.toJsonTree(value1)
                                if (jsonElement.isJsonArray) {
                                    obj.add(key, jsonElement.getAsJsonArray())
                                } else {
                                    obj.add(key, jsonElement.getAsJsonObject())
                                }
                            }
                        }
                    }
                    elementAdapter.write(out, obj)
                }

                @Throws(IOException::class)
                override fun read(`in`: JsonReader): Zebra {
                    val jsonElement = elementAdapter.read(`in`)
                    validateJsonElement(jsonElement)
                    val jsonObj = jsonElement.getAsJsonObject()
                    // store additional fields in the deserialized instance
                    val instance = thisAdapter.fromJsonTree(jsonObj)
                    for ((key, value) in jsonObj.entrySet()) {
                        if (!openapiFields!!.contains(key)) {
                            if (value.isJsonPrimitive) { // primitive type
                                if (value.getAsJsonPrimitive().isString) instance.putAdditionalProperty(key, value.asString) else if (value.getAsJsonPrimitive().isNumber) instance.putAdditionalProperty(key, value.asNumber) else if (value.getAsJsonPrimitive().isBoolean) instance.putAdditionalProperty(key, value.asBoolean) else throw IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", key, value.toString()))
                            } else if (value.isJsonArray) {
                                instance.putAdditionalProperty(key, gson.fromJson<List<*>>(value, MutableList::class.java))
                            } else { // JSON object
                                instance.putAdditionalProperty(key, gson.fromJson(value, HashMap::class.java))
                            }
                        }
                    }
                    return instance
                }
            }.nullSafe() as TypeAdapter<T>
        }
    }

    /**
     * Convert an instance of Zebra to an JSON string
     *
     * @return JSON string
     */
    fun toJson(): String {
        return JSON.getGson().toJson(this)
    }

    companion object {
        const val SERIALIZED_NAME_TYPE = "type"
        const val SERIALIZED_NAME_CLASS_NAME = "className"
        var openapiFields: HashSet<String>? = null
        var openapiRequiredFields: HashSet<String>? = null

        init {
            // a set of all properties/fields (JSON key names)
            openapiFields = HashSet()
            openapiFields!!.add("type")
            openapiFields!!.add("className")

            // a set of required properties/fields (JSON key names)
            openapiRequiredFields = HashSet()
            openapiRequiredFields!!.add("className")
        }

        /**
         * Validates the JSON Element and throws an exception if issues found
         *
         * @param jsonElement JSON Element
         * @throws IOException if the JSON Element is invalid with respect to Zebra
         */
        @Throws(IOException::class)
        fun validateJsonElement(jsonElement: JsonElement?) {
            if (jsonElement == null) {
                require(openapiRequiredFields!!.isEmpty()) {  // has required fields but JSON element is null
                    String.format("The required field(s) %s in Zebra is not found in the empty JSON string", openapiRequiredFields.toString())
                }
            }

            // check to make sure all required properties/fields are present in the JSON string
            for (requiredField in openapiRequiredFields!!) {
                requireNotNull(jsonElement!!.getAsJsonObject()[requiredField]) { String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()) }
            }
            val jsonObj = jsonElement!!.getAsJsonObject()
            require(!(jsonObj["type"] != null && !jsonObj["type"].isJsonNull && !jsonObj["type"].isJsonPrimitive)) { String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj["type"].toString()) }
            // validate the optional field `type`
            if (jsonObj["type"] != null && !jsonObj["type"].isJsonNull) {
                TypeEnum.validateJsonElement(jsonObj["type"])
            }
            require(jsonObj["className"].isJsonPrimitive) { String.format("Expected the field `className` to be a primitive type in the JSON string but got `%s`", jsonObj["className"].toString()) }
        }

        /**
         * Create an instance of Zebra given an JSON string
         *
         * @param jsonString JSON string
         * @return An instance of Zebra
         * @throws IOException if the JSON string is invalid with respect to Zebra
         */
        @Throws(IOException::class)
        fun fromJson(jsonString: String?): Zebra {
            return JSON.getGson().fromJson(jsonString, Zebra::class.java)
        }
    }
}
