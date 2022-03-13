pipeline {
    agent any

    stages {
        stage ('1 gradle clean') {
            steps {
                     gradlew('clean')
            }
        }
        stage('2 docker build image') {
            steps {
                 script {
                     sh 'docker build -t Arzu1996/frontend .'
                 }
            }
        }
        stage('3 deploy the image') {
            steps {
                 script {
                     withCredentials([string(credentialsId: 'Docker-Hub-Password', variable: 'dockerhubpwd')]) {
                         sh 'docker login -u Arzu1996 -p ${dockerhubpwd}'
                     }
                     sh 'docker push  Arzu1996/frontend'
                 }
            }
        }
        stage('4 deploy on K8s') {
            steps {
                 script {
                     sh 'kubectl rollout restart deployment/phonebook-frontend-deployment -n phonebook-app'
                     }
                 }
            }
        }
    }
}