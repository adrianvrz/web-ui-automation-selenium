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
            // Publicar resultados JUnit
            junit 'build/test-results/**/*.xml'
            
            // Publicar Allure Report
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
        success {
            echo 'All tests passed successfully!'
        }
        failure {
            echo 'Some tests failed. Check the reports for details.'
        }
    }
}
