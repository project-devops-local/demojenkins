FROM jenkins/jenkins:2.492.2-lts


#copia y ejecucion plugins jenkins
COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt




