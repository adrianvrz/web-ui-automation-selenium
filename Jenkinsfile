pipeline {
    agent any
    tools {
        jdk 'openjdk-21'      
        gradle 'gradle'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                sh './gradlew clean build'
            }
        }
    }
    post {
        always {
            junit 'build/test-results/test/cucumber.xml'
        }
    }
}
