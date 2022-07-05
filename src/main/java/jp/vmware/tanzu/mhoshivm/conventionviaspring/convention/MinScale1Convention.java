package jp.vmware.tanzu.mhoshivm.conventionviaspring.convention;

import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContextSpec;
import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContextStatus;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1PodTemplateSpec;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Primary
public class MinScale1Convention implements Convention{
    @Override
    public PodConventionContextStatus handler(PodConventionContextSpec podConventionContextSpec, PodConventionContextStatus podConventionContextStatus) {
        String[] appliedConventions = { "addMinScale1" };

        V1PodTemplateSpec podTemplateSpec = podConventionContextSpec.getTemplate();

        V1ObjectMeta objectMeta = podTemplateSpec.getMetadata();
        Map<String, String> annotations = objectMeta.getAnnotations();
        if (annotations != null) {
            annotations.put("autoscaling.knative.dev/minScale", "1");
        }
        objectMeta.setAnnotations(annotations);
        podTemplateSpec.setMetadata(objectMeta);

        podConventionContextStatus.setAppliedConventions(appliedConventions);
        podConventionContextStatus.setTemplate(podTemplateSpec);
        return podConventionContextStatus;
    }
}
