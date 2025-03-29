# Índice de Menú

- [Introducción](#introduccion)
- [Tabla de Contenido](#tabla-de-contenido)
- [Conclusión](#conclusion)

## Introducción
instalacion de jenkins

pasos



registrar en docker hub 
https://hub.docker.com/

logueo al registry local

docker login -u maikol555
token --> es la password para el registry
dckr_pat_tdd8KgMMWkn54JuV0HrBjjP6gE4



* compilar dockerfile ir a la ruta donde este dockerfile
```bash
docker build -t registry/jenkinsultimate:1.0 .
docker login -u user
docker images
docker push maikol555/jenkinsultimate:1.0
```

2 ejecutar el docker-compose

```bash
docker-compose up -d
```

3. 
url de ngrok 
https://ngrok.com/downloads/windows?tab=install


4 configuracion webhook


https://8b49-152-202-24-249.ngrok-free.app/jenkins/generic-webhook-trigger/invoke?token=demotokenjenkins

```
pipeline {
    agent any
    stages {
        stage('Procesar Payload') {
            steps {
                script {
                    // Parsear el payload JSON
                    def jsonPayload = readJSON text: params.payload
                    
                    // Acceder a la propiedad 'action'
                    def action = jsonPayload.action
                    println "Acción: ${action}"
                    
                    // Acceder a la propiedad 'pull_request.url'
                    def pullRequestUrl = jsonPayload.pull_request.url
                    echo "URL del Pull Request: ${pullRequestUrl}"

                    //url
                    def urlgit= jsonPayload.pull_request.base.repo.html_url

                    println "urlgit: "+urlgit

                    def branch = jsonPayload.pull_request.head.ref

                    println "branch: "+branch
                }
            }
        }
    }
}

```