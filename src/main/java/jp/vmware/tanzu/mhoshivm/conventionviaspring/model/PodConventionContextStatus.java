package jp.vmware.tanzu.mhoshivm.conventionviaspring.model;

import io.kubernetes.client.openapi.models.V1PodTemplateSpec;

public class PodConventionContextStatus {
    private V1PodTemplateSpec template;
    private String[] appliedConventions;

    public V1PodTemplateSpec getTemplate() {
        return template;
    }

    public void setTemplate(V1PodTemplateSpec template) {
        this.template = template;
    }

    public String[] getAppliedConventions() {
        return appliedConventions;
    }

    public void setAppliedConventions(String[] appliedConventions) {
        this.appliedConventions = appliedConventions;
    }
}
