pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java 13'
    }
    stages {
        stage('Build Application') {
            steps {
                echo 'Building the Spring Boot Application...'
                sh 'mvn clean package'
            }
        }
        stage('Start Spring Boot Application') {
            steps {
                echo 'Starting the Spring Boot Application...'
                script {
                    // Start the JAR in the background
                    sh 'nohup java -jar target/demo-0.0.1-SNAPSHOT.jar > application.log 2>&1 &'
                    // Wait for the application to be fully initialized
                    sleep 10
                }
            }
        }
        stage('Run Serenity Tests') {
            steps {
                echo 'Running Serenity BDD Tests...'
                sh 'mvn clean verify'
            }
        }
    }
    post {
        always {
            echo 'Stopping the Spring Boot Application...'
            sh 'pkill -f demo-0.0.1-SNAPSHOT.jar'
        }
    }
}
