Very Simple [Convention Service](https://github.com/vmware-tanzu/cartographer-conventions) written in spring boot.  
(This is not [Spring Boot Conventions](https://github.com/vmware-tanzu/cartographer-conventions/tree/main/samples/spring-convention-server))

# How to deploy

This is currently designed to deploy against 
[Tanzu Application Platform](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.1/tap/GUID-install-intro.html)

## Prerequsite

* Tanzu Application Platform 1.1 or higher
* HTTPS endpoint is available (instructions is [here](https://ik.am/entries/699))
* Non-Self-Signed valid SSL certificate used for  `default_tls_secret`

## Using Tilt

Execute the following

```
export SOURCE_IMAGE=<Your Repo>/<Project>/<Source Image Name>
tilt up
```

After deploying, tilt will send updated codes once `targets/*.class` has been updated.

## Applying the Convention Server

Update `spec.webhook.clientWebhook.url` values in `k8s/ClusterPodConvention.yaml`

```
kubectl apply -f k8s/ClusterPodConvention.yaml
```

# Sample Conventions

Sample convention to add `MinScale:1` to all deployments is added as [MinScale1Convention](src/main/java/jp/vmware/tanzu/mhoshivm/conventionviaspring/convention)

# Trying it out

```
kubectl apply -f k8s/podintent_sample.yaml
```

After applying the above check the status of the podintent

```
kubectl get podintents -o yaml podintent-test
```

Should look like the below

```aidl
status:
...
  template:
    metadata:
      annotations:
        autoscaling.knative.dev/minScale: "1"
        conventions.apps.tanzu.vmware.com/applied-conventions: covention-via-spring/addMinScale1
...
```
