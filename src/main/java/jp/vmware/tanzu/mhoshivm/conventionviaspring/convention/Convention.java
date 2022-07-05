package jp.vmware.tanzu.mhoshivm.conventionviaspring.convention;

import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContextSpec;
import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContextStatus;

public interface Convention {

    void handler(PodConventionContextSpec podConventionContextSpec, PodConventionContextStatus podConventionContextStatus);
}
