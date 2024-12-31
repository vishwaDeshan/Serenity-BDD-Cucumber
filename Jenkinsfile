pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java 17'
    }
    stages {
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
