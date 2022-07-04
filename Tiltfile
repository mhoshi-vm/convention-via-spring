
SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='harbor.cl01.lespaulstudioplus.info/library/my-convention')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='default')

k8s_custom_deploy(
    'my-convention',
    apply_cmd="tanzu apps workload apply my-convention --live-update=true" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --type web" +
               " --namespace " + NAMESPACE +
               " --yes >/dev/null" +
               " && kubectl get workload my-convention --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete my-convention --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('my-convention', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'my-convention'}])

allow_k8s_contexts('tap01-cl01')