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
 * A pet for sale in the pet store
 */
@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:33.796785+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class Pet {
    /**
     * Get id
     * @return id
     */
    @SerializedName(SERIALIZED_NAME_ID)
    var id: Long? = null

    /**
     * Get category
     * @return category
     */
    @SerializedName(SERIALIZED_NAME_CATEGORY)
    var category: Category? = null

    /**
     * Get name
     * @return name
     */
    @get:Nonnull
    @SerializedName(SERIALIZED_NAME_NAME)
    var name: String? = null

    @SerializedName(SERIALIZED_NAME_PHOTO_URLS)
    private var photoUrls: MutableList<String>? = ArrayList()

    @SerializedName(SERIALIZED_NAME_TAGS)
    private var tags: MutableList<Tag>? = ArrayList()

    /**
     * pet status in the store
     */
    @JsonAdapter(StatusEnum.Adapter::class)
    enum class StatusEnum(val value: String) {
        AVAILABLE("available"),
        PENDING("pending"),
        SOLD("sold");

        override fun toString(): String {
            return value.toString()
        }

        class Adapter : TypeAdapter<StatusEnum>() {
            @Throws(IOException::class)
            override fun write(jsonWriter: JsonWriter, enumeration: StatusEnum) {
                jsonWriter.value(enumeration.value)
            }

            @Throws(IOException::class)
            override fun read(jsonReader: JsonReader): StatusEnum {
                val value = jsonReader.nextString()
                return fromValue(value)
            }
        }

        companion object {
            fun fromValue(value: String): StatusEnum {
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
     * pet status in the store
     * @return status
     */
    @get:Deprecated("")
    @set:Deprecated("")
    @Deprecated("")
    @SerializedName(SERIALIZED_NAME_STATUS)
    var status: StatusEnum? = null
    fun id(id: Long?): Pet {
        this.id = id
        return this
    }

    fun category(category: Category?): Pet {
        this.category = category
        return this
    }

    fun name(name: String?): Pet {
        this.name = name
        return this
    }

    fun photoUrls(photoUrls: MutableList<String>?): Pet {
        this.photoUrls = photoUrls
        return this
    }

    fun addPhotoUrlsItem(photoUrlsItem: String): Pet {
        if (photoUrls == null) {
            photoUrls = ArrayList()
        }
        photoUrls!!.add(photoUrlsItem)
        return this
    }

    /**
     * Get photoUrls
     * @return photoUrls
     */
    @Nonnull
    fun getPhotoUrls(): List<String>? {
        return photoUrls
    }

    fun setPhotoUrls(photoUrls: MutableList<String>?) {
        this.photoUrls = photoUrls
    }

    fun tags(tags: MutableList<Tag>?): Pet {
        this.tags = tags
        return this
    }

    fun addTagsItem(tagsItem: Tag): Pet {
        if (tags == null) {
            tags = ArrayList()
        }
        tags!!.add(tagsItem)
        return this
    }

    /**
     * Get tags
     * @return tags
     */
    fun getTags(): List<Tag>? {
        return tags
    }

    fun setTags(tags: MutableList<Tag>?) {
        this.tags = tags
    }

    @Deprecated("")
    fun status(status: StatusEnum?): Pet {
        this.status = status
        return this
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val pet = o as Pet
        return id == pet.id && this.category == pet.category && name == pet.name && photoUrls == pet.photoUrls && tags == pet.tags && status == pet.status
    }

    override fun hashCode(): Int {
        return Objects.hash(id, category, name, photoUrls, tags, status)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Pet {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    category: ").append(toIndentedString(category)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n")
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n")
        sb.append("    status: ").append(toIndentedString(status)).append("\n")
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
            if (!Pet::class.java.isAssignableFrom(type.rawType)) {
                return null // this class only serializes 'Pet' and its subtypes
            }
            val elementAdapter = gson.getAdapter(JsonElement::class.java)
            val thisAdapter = gson.getDelegateAdapter(this, TypeToken.get(Pet::class.java))
            return object : TypeAdapter<Pet>() {
                @Throws(IOException::class)
                override fun write(out: JsonWriter, value: Pet) {
                    val obj = thisAdapter.toJsonTree(value).getAsJsonObject()
                    elementAdapter.write(out, obj)
                }

                @Throws(IOException::class)
                override fun read(`in`: JsonReader): Pet {
                    val jsonElement = elementAdapter.read(`in`)
                    validateJsonElement(jsonElement)
                    return thisAdapter.fromJsonTree(jsonElement)
                }
            }.nullSafe() as TypeAdapter<T>
        }
    }

    /**
     * Convert an instance of Pet to an JSON string
     *
     * @return JSON string
     */
    fun toJson(): String {
        return JSON.getGson().toJson(this)
    }

    companion object {
        const val SERIALIZED_NAME_ID = "id"
        const val SERIALIZED_NAME_CATEGORY = "category"
        const val SERIALIZED_NAME_NAME = "name"
        const val SERIALIZED_NAME_PHOTO_URLS = "photoUrls"
        const val SERIALIZED_NAME_TAGS = "tags"
        const val SERIALIZED_NAME_STATUS = "status"
        var openapiFields: HashSet<String>? = null
        var openapiRequiredFields: HashSet<String>? = null

        init {
            // a set of all properties/fields (JSON key names)
            openapiFields = HashSet()
            openapiFields!!.add("id")
            openapiFields!!.add("category")
            openapiFields!!.add("name")
            openapiFields!!.add("photoUrls")
            openapiFields!!.add("tags")
            openapiFields!!.add("status")

            // a set of required properties/fields (JSON key names)
            openapiRequiredFields = HashSet()
            openapiRequiredFields!!.add("name")
            openapiRequiredFields!!.add("photoUrls")
        }

        /**
         * Validates the JSON Element and throws an exception if issues found
         *
         * @param jsonElement JSON Element
         * @throws IOException if the JSON Element is invalid with respect to Pet
         */
        @Throws(IOException::class)
        fun validateJsonElement(jsonElement: JsonElement?) {
            if (jsonElement == null) {
                require(openapiRequiredFields!!.isEmpty()) {  // has required fields but JSON element is null
                    String.format("The required field(s) %s in Pet is not found in the empty JSON string", openapiRequiredFields.toString())
                }
            }
            val entries = jsonElement!!.getAsJsonObject().entrySet()
            // check to see if the JSON string contains additional fields
            for ((key) in entries) {
                require(openapiFields!!.contains(key)) { String.format("The field `%s` in the JSON string is not defined in the `Pet` properties. JSON: %s", key, jsonElement.toString()) }
            }

            // check to make sure all required properties/fields are present in the JSON string
            for (requiredField in openapiRequiredFields!!) {
                requireNotNull(jsonElement.getAsJsonObject()[requiredField]) { String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()) }
            }
            val jsonObj = jsonElement.getAsJsonObject()
            // validate the optional field `category`
            if (jsonObj["category"] != null && !jsonObj["category"].isJsonNull) {
                Category.Companion.validateJsonElement(jsonObj["category"])
            }
            require(jsonObj["name"].isJsonPrimitive) { String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj["name"].toString()) }
            // ensure the required json array is present
            requireNotNull(jsonObj["photoUrls"]) { "Expected the field `linkedContent` to be an array in the JSON string but got `null`" }
            require(jsonObj["photoUrls"].isJsonArray) { String.format("Expected the field `photoUrls` to be an array in the JSON string but got `%s`", jsonObj["photoUrls"].toString()) }
            if (jsonObj["tags"] != null && !jsonObj["tags"].isJsonNull) {
                val jsonArraytags = jsonObj.getAsJsonArray("tags")
                if (jsonArraytags != null) {
                    // ensure the json data is an array
                    require(jsonObj["tags"].isJsonArray) { String.format("Expected the field `tags` to be an array in the JSON string but got `%s`", jsonObj["tags"].toString()) }

                    // validate the optional field `tags` (array)
                    for (i in 0 until jsonArraytags.size()) {
                        Tag.Companion.validateJsonElement(jsonArraytags[i])
                    }
                }
            }
            require(!(jsonObj["status"] != null && !jsonObj["status"].isJsonNull && !jsonObj["status"].isJsonPrimitive)) { String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj["status"].toString()) }
            // validate the optional field `status`
            if (jsonObj["status"] != null && !jsonObj["status"].isJsonNull) {
                StatusEnum.validateJsonElement(jsonObj["status"])
            }
        }

        /**
         * Create an instance of Pet given an JSON string
         *
         * @param jsonString JSON string
         * @return An instance of Pet
         * @throws IOException if the JSON string is invalid with respect to Pet
         */
        @Throws(IOException::class)
        fun fromJson(jsonString: String?): Pet {
            return JSON.getGson().fromJson(jsonString, Pet::class.java)
        }
    }
}