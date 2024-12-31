pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java 17'
    }
    stages {
        stage('SCM Checkout') {
            steps {
                retry(3) {
                    git branch: 'main', url: 'https://github.com/chandulakavishka/Group-20_Serenity.git'
                }
            }
        }
        // stage('Build') {
        //     steps {
        //         script {
        //             def jarFile = 'demo-0.0.1-SNAPSHOT.jar'
        //             bat "java -jar ${jarFile}"
        //         }
        //     }
        // }
        stage('Test') {
            steps {
                bat 'mvn clean verify'
            }
        }
    }
}
