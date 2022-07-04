Very Simple [Convention Service](https://github.com/vmware-tanzu/cartographer-conventions) written in spring boot.  
(This is not [Spring Boot Conventions](https://github.com/vmware-tanzu/cartographer-conventions/tree/main/samples/spring-convention-server))

# How to deploy

This is currently designed to deploy against 
[Tanzu Application Platform](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.1/tap/GUID-install-intro.html)

## Using Tilt

Execute the following

```
tilt up
```

After deploying, tilt will send updated codes once `targets/*.class` has been updated.

## Applying the Convention Server

Update required values in `k8s/sample.yaml`

```
kubectl apply -f k8s/sample.yaml
```

# Sample Conventions

Sample convention to add `MinScale:1` to all deployments is added as [MinScale1Convention](src/main/jp/vmware/tanzu/mhoshivm/conventionviaspring/convention)
