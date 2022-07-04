package jp.vmware.tanzu.mhoshivm.conventionviaspring.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Keeps json value as json, does not try to deserialize it
 * @author roytruelove
 *
 */
public class KeepAsJsonDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        TreeNode tree = jp.getCodec().readTree(jp);
        return tree.toString();
    }
}