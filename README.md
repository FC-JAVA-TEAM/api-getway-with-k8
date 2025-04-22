🛡️ Tech Stack

📣 Related Projects
User-service 
https://github.com/FC-JAVA-TEAM/user-service-with-k8-and-api-getway

🚀 Project Overview
This project demonstrates a Kubernetes-ready Spring Boot API Gateway with dynamic service discovery using environment variables.
It enables flexible routing between microservices without hardcoding any URLs.

📄 Deployment Instructions
1. Using deployment-dns-01.yaml
The file deployment-dns-01.yaml contains the complete Kubernetes Deployment and Service configuration for the API Gateway.

It defines how the application will be deployed inside the cluster, including:

Docker image details

Kubernetes environment variables

Resource limits and requests

Service exposure

✅ This file is in a fully working state and can be applied directly to your Kubernetes cluster:

bash
Copy
Edit
kubectl apply -f deployment-dns-01.yaml
2. Passing Service URLs through Environment Variables
In this approach, service URLs are passed to the application dynamically via Kubernetes environment variables.

These are injected inside the running container without modifying the codebase.

The app reads the environment variables at runtime to determine where to route incoming requests.

Example snippet from deployment-dns-01.yaml:

yaml
Copy
Edit
env:
  - name: USER_SERVICE_URI
    value: "http://user-service.default.svc.cluster.local:80"
  - name: NOTE_APP_URI
    value: "http://note-service.default.svc.cluster.local:77"
This eliminates hardcoded values and supports multi-environment deployments easily (Dev, QA, UAT, Prod).

3. Override via Kubernetes Environment Variables
Using Kubernetes env: block, we can override application properties without touching the application code.
Advantages:

🔄 Dynamic configuration management

🌎 Environment-specific deployments (different for dev/staging/prod)

🚀 No code changes required for service URL updates

🛡️ Separation of config and code

The app (API Gateway) uses placeholders (like ${USER_SERVICE_URI}) which get dynamically resolved using these injected environment variables.

✨ Deployment Architecture Flow
Here’s a simple visualization of the flow:

lua
Copy
Edit


Kubernetes Deployment
   |
   |---> Environment Variables (USER_SERVICE_URI, NOTE_APP_URI)
           |
           |---> Injected inside Container at runtime
                   |
                   |---> Spring Boot App reads Environment Variables
                           |
                           |---> Gateway dynamically routes to correct services


📋 Quick Summary
Deploy using deployment-dns-01.yaml — production-ready setup.

Service discovery is handled using environment variables injected by Kubernetes.

No need to hardcode any service URL inside the application.

Supports dynamic, scalable, and environment-specific microservices deployments.

Follow best practices for 12-factor app and cloud-native deployments.

🙌 Contributions
If you find any improvements or want to contribute, feel free to raise a Pull Request.
Happy coding! 🚀

