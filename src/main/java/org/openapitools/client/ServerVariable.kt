package org.openapitools.client

import javax.annotation.Generated

/**
 * Representing a Server Variable for server URL template substitution.
 */
@Generated(value = ["org.openapitools.codegen.languages.JavaClientCodegen"], date = "2024-04-14T17:24:33.796785+08:00[Asia/Hong_Kong]", comments = "Generator version: 7.5.0-SNAPSHOT")
class ServerVariable(var description: String, var defaultValue: String, enumValues: HashSet<String?>?) {
    var enumValues: HashSet<String?>? = null

    /**
     * @param description A description for the server variable.
     * @param defaultValue The default value to use for substitution.
     * @param enumValues An enumeration of string values to be used if the substitution options are from a limited set.
     */
    init {
        this.enumValues = enumValues
    }
}
