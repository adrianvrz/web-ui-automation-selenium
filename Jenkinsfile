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
                sh './gradlew clean cucumber'
            }
        }
    }
    post {
        always {
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'build/reports',
                reportFiles: 'cucumber.html',
                reportName: 'Cucumber Report'
            ])
            junit 'build/test-results/test/cucumber.xml'
        }
    }
}
