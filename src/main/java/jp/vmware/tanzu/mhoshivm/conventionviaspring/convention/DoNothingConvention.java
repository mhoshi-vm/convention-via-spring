package jp.vmware.tanzu.mhoshivm.conventionviaspring.convention;


import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContextSpec;
import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContextStatus;
import io.kubernetes.client.openapi.models.V1PodTemplateSpec;
import org.springframework.stereotype.Component;

@Component
public class DoNothingConvention implements Convention{
    @Override
    public void handler(PodConventionContextSpec podConventionContextSpec, PodConventionContextStatus podConventionContextStatus) {

        String[] appliedConventions = { "do-nothing" };

        V1PodTemplateSpec podTemplateSpec = podConventionContextSpec.getTemplate();
        podConventionContextStatus.setAppliedConventions(appliedConventions);
        podConventionContextStatus.setTemplate(podTemplateSpec);
    }
}
