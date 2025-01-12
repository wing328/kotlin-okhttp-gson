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
class Mammal : AbstractOpenApiSchema {
    class CustomTypeAdapterFactory : TypeAdapterFactory {
        override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
            if (!Mammal::class.java.isAssignableFrom(type.rawType)) {
                return null // this class only serializes 'Mammal' and its subtypes
            }
            val elementAdapter = gson.getAdapter(JsonElement::class.java)
            val adapterWhale = gson.getDelegateAdapter(this, TypeToken.get(Whale::class.java))
            val adapterZebra = gson.getDelegateAdapter(this, TypeToken.get(Zebra::class.java))
            val adapterPig = gson.getDelegateAdapter(this, TypeToken.get(Pig::class.java))
            return object : TypeAdapter<Mammal?>() {
                @Throws(IOException::class)
                override fun write(out: JsonWriter, value: Mammal?) {
                    if (value == null || value.actualInstance == null) {
                        elementAdapter.write(out, null)
                        return
                    }

                    // check if the actual instance is of the type `Whale`
                    if (value.actualInstance is Whale) {
                        val element = adapterWhale.toJsonTree(value.actualInstance as Whale?)
                        elementAdapter.write(out, element)
                        return
                    }
                    // check if the actual instance is of the type `Zebra`
                    if (value.actualInstance is Zebra) {
                        val element = adapterZebra.toJsonTree(value.actualInstance as Zebra?)
                        elementAdapter.write(out, element)
                        return
                    }
                    // check if the actual instance is of the type `Pig`
                    if (value.actualInstance is Pig) {
                        val element = adapterPig.toJsonTree(value.actualInstance as Pig?)
                        elementAdapter.write(out, element)
                        return
                    }
                    throw IOException("Failed to serialize as the type doesn't match oneOf schemas: Pig, Whale, Zebra")
                }

                @Throws(IOException::class)
                override fun read(`in`: JsonReader): Mammal? {
                    val deserialized: Any? = null
                    val jsonElement = elementAdapter.read(`in`)
                    var match = 0
                    val errorMessages = ArrayList<String>()
                    var actualAdapter: TypeAdapter<*> = elementAdapter

                    // deserialize Whale
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Whale.Companion.validateJsonElement(jsonElement)
                        actualAdapter = adapterWhale
                        match++
                        log.log(Level.FINER, "Input data matches schema 'Whale'")
                    } catch (e: Exception) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Whale failed with `%s`.", e.message))
                        log.log(Level.FINER, "Input data does not match schema 'Whale'", e)
                    }
                    // deserialize Zebra
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Zebra.Companion.validateJsonElement(jsonElement)
                        actualAdapter = adapterZebra
                        match++
                        log.log(Level.FINER, "Input data matches schema 'Zebra'")
                    } catch (e: Exception) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Zebra failed with `%s`.", e.message))
                        log.log(Level.FINER, "Input data does not match schema 'Zebra'", e)
                    }
                    // deserialize Pig
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Pig.Companion.validateJsonElement(jsonElement)
                        actualAdapter = adapterPig
                        match++
                        log.log(Level.FINER, "Input data matches schema 'Pig'")
                    } catch (e: Exception) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Pig failed with `%s`.", e.message))
                        log.log(Level.FINER, "Input data does not match schema 'Pig'", e)
                    }
                    if (match == 1) {
                        val ret = Mammal()
                        ret.actualInstance = actualAdapter.fromJsonTree(jsonElement)
                        return ret
                    }
                    throw IOException(String.format("Failed deserialization for Mammal: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()))
                }
            }.nullSafe() as TypeAdapter<T>
        }
    }

    constructor() : super("oneOf", Boolean.FALSE)
    constructor(o: Pig?) : super("oneOf", Boolean.FALSE) {
        actualInstance = o
    }

    constructor(o: Whale?) : super("oneOf", Boolean.FALSE) {
        actualInstance = o
    }

    constructor(o: Zebra?) : super("oneOf", Boolean.FALSE) {
        actualInstance = o
    }

    override val schemas: Map<String?, Class<*>?>?
        get() = Companion.schemas
    override var actualInstance: Any?
        /**
         * Get the actual instance, which can be the following:
         * Pig, Whale, Zebra
         *
         * @return The actual instance (Pig, Whale, Zebra)
         */
        get() = super.getActualInstance()
        /**
         * Set the instance that matches the oneOf child schema, check
         * the instance parameter is valid against the oneOf child schemas:
         * Pig, Whale, Zebra
         *
         * It could be an instance of the 'oneOf' schemas.
         */
        set(instance) {
            if (instance is Whale) {
                super.setActualInstance(instance)
                return
            }
            if (instance is Zebra) {
                super.setActualInstance(instance)
                return
            }
            if (instance is Pig) {
                super.setActualInstance(instance)
                return
            }
            throw RuntimeException("Invalid instance type. Must be Pig, Whale, Zebra")
        }

    @get:Throws(ClassCastException::class)
    val whale: Whale?
        /**
         * Get the actual instance of `Whale`. If the actual instance is not `Whale`,
         * the ClassCastException will be thrown.
         *
         * @return The actual instance of `Whale`
         * @throws ClassCastException if the instance is not `Whale`
         */
        get() = super.getActualInstance() as Whale

    @get:Throws(ClassCastException::class)
    val zebra: Zebra?
        /**
         * Get the actual instance of `Zebra`. If the actual instance is not `Zebra`,
         * the ClassCastException will be thrown.
         *
         * @return The actual instance of `Zebra`
         * @throws ClassCastException if the instance is not `Zebra`
         */
        get() = super.getActualInstance() as Zebra

    @get:Throws(ClassCastException::class)
    val pig: Pig?
        /**
         * Get the actual instance of `Pig`. If the actual instance is not `Pig`,
         * the ClassCastException will be thrown.
         *
         * @return The actual instance of `Pig`
         * @throws ClassCastException if the instance is not `Pig`
         */
        get() = super.getActualInstance() as Pig

    /**
     * Convert an instance of Mammal to an JSON string
     *
     * @return JSON string
     */
    fun toJson(): String {
        return JSON.getGson().toJson(this)
    }

    companion object {
        private val log = Logger.getLogger(Mammal::class.java.name)

        // store a list of schema names defined in oneOf
        val schemas: Map<String, Class<*>> = HashMap()

        init {
            schemas.put("Whale", Whale::class.java)
            schemas.put("Zebra", Zebra::class.java)
            schemas.put("Pig", Pig::class.java)
        }

        /**
         * Validates the JSON Element and throws an exception if issues found
         *
         * @param jsonElement JSON Element
         * @throws IOException if the JSON Element is invalid with respect to Mammal
         */
        @Throws(IOException::class)
        fun validateJsonElement(jsonElement: JsonElement) {
            // validate oneOf schemas one by one
            var validCount = 0
            val errorMessages = ArrayList<String>()
            // validate the json string with Whale
            try {
                Whale.Companion.validateJsonElement(jsonElement)
                validCount++
            } catch (e: Exception) {
                errorMessages.add(String.format("Deserialization for Whale failed with `%s`.", e.message))
                // continue to the next one
            }
            // validate the json string with Zebra
            try {
                Zebra.Companion.validateJsonElement(jsonElement)
                validCount++
            } catch (e: Exception) {
                errorMessages.add(String.format("Deserialization for Zebra failed with `%s`.", e.message))
                // continue to the next one
            }
            // validate the json string with Pig
            try {
                Pig.Companion.validateJsonElement(jsonElement)
                validCount++
            } catch (e: Exception) {
                errorMessages.add(String.format("Deserialization for Pig failed with `%s`.", e.message))
                // continue to the next one
            }
            if (validCount != 1) {
                throw IOException(String.format("The JSON string is invalid for Mammal with oneOf schemas: Pig, Whale, Zebra. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()))
            }
        }

        /**
         * Create an instance of Mammal given an JSON string
         *
         * @param jsonString JSON string
         * @return An instance of Mammal
         * @throws IOException if the JSON string is invalid with respect to Mammal
         */
        @Throws(IOException::class)
        fun fromJson(jsonString: String?): Mammal {
            return JSON.getGson().fromJson(jsonString, Mammal::class.java)
        }
    }
}
