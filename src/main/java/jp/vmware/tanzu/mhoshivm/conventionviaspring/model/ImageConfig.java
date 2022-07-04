package jp.vmware.tanzu.mhoshivm.conventionviaspring.model;

import jp.vmware.tanzu.mhoshivm.conventionviaspring.config.KeepAsJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ImageConfig {
    public String image;
    public BOM[] boms;

    @JsonDeserialize(using = KeepAsJsonDeserializer.class)
    @JsonRawValue
    public String config;
}
