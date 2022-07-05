package jp.vmware.tanzu.mhoshivm.conventionviaspring.controller;

import jp.vmware.tanzu.mhoshivm.conventionviaspring.convention.Convention;
import jp.vmware.tanzu.mhoshivm.conventionviaspring.model.PodConventionContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    Convention convention;

    public RestController(Convention convention) {
        this.convention = convention;
    }

    @PostMapping (value = "/convention", produces = MediaType.APPLICATION_JSON_VALUE)
    public PodConventionContext Convention(@RequestBody PodConventionContext podConventionContext) {

        podConventionContext.setStatus(convention.handler(podConventionContext.getSpec(), podConventionContext.getStatus()));

        return podConventionContext;
    }
}
