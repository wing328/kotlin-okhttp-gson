package org.openapitools.client

import javax.annotation.Generated

/**
 * Representing a Server configuration.
 */
@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:33.796785+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class ServerConfiguration
/**
 * @param URL A URL to the target host.
 * @param description A description of the host designated by the URL.
 * @param variables A map between a variable name and its value. The value is used for substitution in the server's URL template.
 */(var URL: String, var description: String, var variables: Map<String, ServerVariable>) {
    /**
     * Format URL template using given variables.
     *
     * @param variables A map between a variable name and its value.
     * @return Formatted URL.
     */
    /**
     * Format URL template using default server variables.
     *
     * @return Formatted URL.
     */
    @JvmOverloads
    fun URL(variables: Map<String, String>? = null): String {
        var url = URL

        // go through variables and replace placeholders
        for ((name, serverVariable) in this.variables) {
            var value = serverVariable.defaultValue
            if (variables != null && variables.containsKey(name)) {
                value = variables[name]
                require(!(serverVariable.enumValues!!.size > 0 && !serverVariable.enumValues!!.contains(value))) { "The variable $name in the server URL has invalid value $value." }
            }
            url = url.replace("{$name}", value!!)
        }
        return url
    }
}
