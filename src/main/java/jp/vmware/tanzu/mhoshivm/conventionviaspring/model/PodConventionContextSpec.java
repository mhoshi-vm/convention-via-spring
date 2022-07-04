package jp.vmware.tanzu.mhoshivm.conventionviaspring.model;

import io.kubernetes.client.openapi.models.V1PodTemplateSpec;

public class PodConventionContextSpec {
    public V1PodTemplateSpec template;
    public ImageConfig[] imageConfig;

    public V1PodTemplateSpec getTemplate() {
        return template;
    }

    public ImageConfig[] getImageConfig() {
        return imageConfig;
    }
}
