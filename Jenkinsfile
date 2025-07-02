pipeline {
    agent any
    tools {
        jdk 'openjdk-21'      
        gradle 'gradle-8.14.2'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
    post {
        always {
            junit 'build/test-results/**/*.xml'
        }
    }
}
