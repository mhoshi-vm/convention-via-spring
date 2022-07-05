package jp.vmware.tanzu.mhoshivm.conventionviaspring.model;

import com.fasterxml.jackson.databind.JsonNode;

public class ImageConfig {
    public String image;
    public BOM[] boms;
    public JsonNode config;
}
