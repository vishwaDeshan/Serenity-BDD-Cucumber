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
        //             sh "java -jar ${jarFile}"
        //         }
        //     }
        // }
        stage('Test') {
            steps {
                
                sh 'mvn clean verify'
            }
        }
    }
}
