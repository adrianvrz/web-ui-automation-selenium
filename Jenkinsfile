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
        
        stage('Test') {
            steps {
                sh './gradlew clean cucumber -Dbrowser=chrome -Dheadless=true'
            }
        }
    }
    
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            junit 'build/test-results/test/cucumber.xml'
        }
    }
}
