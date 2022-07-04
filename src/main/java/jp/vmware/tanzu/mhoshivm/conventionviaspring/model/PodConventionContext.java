package jp.vmware.tanzu.mhoshivm.conventionviaspring.model;

import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class PodConventionContext {
    public String apiVersion;
    public String kind;
    public V1ObjectMeta metadata;
    public PodConventionContextSpec spec;
    public PodConventionContextStatus status;

    public PodConventionContextSpec getSpec() {
        return spec;
    }

    public PodConventionContextStatus getStatus() {
        return status;
    }

    public void setStatus(PodConventionContextStatus status) {
        this.status = status;
    }
}
