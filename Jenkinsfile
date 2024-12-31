pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java 17'
    }
    stages {
        stage('build') {
            steps {
                echo 'Hello World'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '83eac14f-4484-44c7-8131-cec343c3af19', url: 'https://github.com/chandulakavishka/Group-20_Serenity.git']])
                sh 'mvn -B -Dmaven.test.failure.ignore=true clean package'
            }
        }
        post {
            always {
                junit(
                    allowEmptyResults: true,
                    testResults: 'target/surefire-reports/*.xml'
                )
            }
        }
    }
}
