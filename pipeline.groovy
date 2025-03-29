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

                    checkout scmGit(branches: [[name: branch]], extensions: [], userRemoteConfigs: [[credentialsId: 'github-credential', url: urlgit]])

                    sh "ls -ltra"
                }
            }
        }
    }
}