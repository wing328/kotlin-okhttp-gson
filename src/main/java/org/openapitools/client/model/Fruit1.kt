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
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.openapitools.client.JSON
import java.io.IOException
import java.lang.Boolean
import java.util.logging.Level
import java.util.logging.Logger
import javax.annotation.Generated
import kotlin.Any
import kotlin.ClassCastException
import kotlin.Exception
import kotlin.RuntimeException
import kotlin.String
import kotlin.Throws

@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:33.796785+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class Fruit : AbstractOpenApiSchema {
    class CustomTypeAdapterFactory : TypeAdapterFactory {
        override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
            if (!Fruit::class.java.isAssignableFrom(type.rawType)) {
                return null // this class only serializes 'Fruit' and its subtypes
            }
            val elementAdapter = gson.getAdapter(JsonElement::class.java)
            val adapterApple = gson.getDelegateAdapter(this, TypeToken.get(Apple::class.java))
            val adapterBanana = gson.getDelegateAdapter(this, TypeToken.get(Banana::class.java))
            return object : TypeAdapter<Fruit?>() {
                @Throws(IOException::class)
                override fun write(out: JsonWriter, value: Fruit?) {
                    if (value == null || value.actualInstance == null) {
                        elementAdapter.write(out, null)
                        return
                    }

                    // check if the actual instance is of the type `Apple`
                    if (value.actualInstance is Apple) {
                        val element = adapterApple.toJsonTree(value.actualInstance as Apple?)
                        elementAdapter.write(out, element)
                        return
                    }
                    // check if the actual instance is of the type `Banana`
                    if (value.actualInstance is Banana) {
                        val element = adapterBanana.toJsonTree(value.actualInstance as Banana?)
                        elementAdapter.write(out, element)
                        return
                    }
                    throw IOException("Failed to serialize as the type doesn't match oneOf schemas: Apple, Banana")
                }

                @Throws(IOException::class)
                override fun read(`in`: JsonReader): Fruit? {
                    val deserialized: Any? = null
                    val jsonElement = elementAdapter.read(`in`)
                    var match = 0
                    val errorMessages = ArrayList<String>()
                    var actualAdapter: TypeAdapter<*> = elementAdapter

                    // deserialize Apple
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Apple.Companion.validateJsonElement(jsonElement)
                        actualAdapter = adapterApple
                        match++
                        log.log(Level.FINER, "Input data matches schema 'Apple'")
                    } catch (e: Exception) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Apple failed with `%s`.", e.message))
                        log.log(Level.FINER, "Input data does not match schema 'Apple'", e)
                    }
                    // deserialize Banana
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Banana.Companion.validateJsonElement(jsonElement)
                        actualAdapter = adapterBanana
                        match++
                        log.log(Level.FINER, "Input data matches schema 'Banana'")
                    } catch (e: Exception) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Banana failed with `%s`.", e.message))
                        log.log(Level.FINER, "Input data does not match schema 'Banana'", e)
                    }
                    if (match == 1) {
                        val ret = Fruit()
                        ret.actualInstance = actualAdapter.fromJsonTree(jsonElement)
                        return ret
                    }
                    throw IOException(String.format("Failed deserialization for Fruit: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()))
                }
            }.nullSafe() as TypeAdapter<T>
        }
    }

    constructor() : super("oneOf", Boolean.FALSE)
    constructor(o: Apple?) : super("oneOf", Boolean.FALSE) {
        actualInstance = o
    }

    constructor(o: Banana?) : super("oneOf", Boolean.FALSE) {
        actualInstance = o
    }

    override val schemas: Map<String?, Class<*>?>?
        get() = Companion.schemas
    override var actualInstance: Any?
        /**
         * Get the actual instance, which can be the following:
         * Apple, Banana
         *
         * @return The actual instance (Apple, Banana)
         */
        get() = super.getActualInstance()
        /**
         * Set the instance that matches the oneOf child schema, check
         * the instance parameter is valid against the oneOf child schemas:
         * Apple, Banana
         *
         * It could be an instance of the 'oneOf' schemas.
         */
        set(instance) {
            if (instance is Apple) {
                super.setActualInstance(instance)
                return
            }
            if (instance is Banana) {
                super.setActualInstance(instance)
                return
            }
            throw RuntimeException("Invalid instance type. Must be Apple, Banana")
        }

    @get:Throws(ClassCastException::class)
    val apple: Apple?
        /**
         * Get the actual instance of `Apple`. If the actual instance is not `Apple`,
         * the ClassCastException will be thrown.
         *
         * @return The actual instance of `Apple`
         * @throws ClassCastException if the instance is not `Apple`
         */
        get() = super.getActualInstance() as Apple

    @get:Throws(ClassCastException::class)
    val banana: Banana?
        /**
         * Get the actual instance of `Banana`. If the actual instance is not `Banana`,
         * the ClassCastException will be thrown.
         *
         * @return The actual instance of `Banana`
         * @throws ClassCastException if the instance is not `Banana`
         */
        get() = super.getActualInstance() as Banana

    /**
     * Convert an instance of Fruit to an JSON string
     *
     * @return JSON string
     */
    fun toJson(): String {
        return JSON.getGson().toJson(this)
    }

    companion object {
        private val log = Logger.getLogger(Fruit::class.java.name)

        // store a list of schema names defined in oneOf
        val schemas: Map<String, Class<*>> = HashMap()

        init {
            schemas.put("Apple", Apple::class.java)
            schemas.put("Banana", Banana::class.java)
        }

        /**
         * Validates the JSON Element and throws an exception if issues found
         *
         * @param jsonElement JSON Element
         * @throws IOException if the JSON Element is invalid with respect to Fruit
         */
        @Throws(IOException::class)
        fun validateJsonElement(jsonElement: JsonElement) {
            // validate oneOf schemas one by one
            var validCount = 0
            val errorMessages = ArrayList<String>()
            // validate the json string with Apple
            try {
                Apple.Companion.validateJsonElement(jsonElement)
                validCount++
            } catch (e: Exception) {
                errorMessages.add(String.format("Deserialization for Apple failed with `%s`.", e.message))
                // continue to the next one
            }
            // validate the json string with Banana
            try {
                Banana.Companion.validateJsonElement(jsonElement)
                validCount++
            } catch (e: Exception) {
                errorMessages.add(String.format("Deserialization for Banana failed with `%s`.", e.message))
                // continue to the next one
            }
            if (validCount != 1) {
                throw IOException(String.format("The JSON string is invalid for Fruit with oneOf schemas: Apple, Banana. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()))
            }
        }

        /**
         * Create an instance of Fruit given an JSON string
         *
         * @param jsonString JSON string
         * @return An instance of Fruit
         * @throws IOException if the JSON string is invalid with respect to Fruit
         */
        @Throws(IOException::class)
        fun fromJson(jsonString: String?): Fruit {
            return JSON.getGson().fromJson(jsonString, Fruit::class.java)
        }
    }
}
