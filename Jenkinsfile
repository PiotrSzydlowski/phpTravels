pipeline {
    agent any
    stages {
        stage('Build test code') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Run selenium grid') {
                    steps {
                        bat 'docker-compose up -d' // Uruchiomienie Docker Selenium
                    }
                }
        stage('Execute test') {
            steps {
                 bat 'mvn test' // Uruchomienie testów
                 bat 'docker-compose down' // Wyłączenie Docker Selenium, wyłączenie kontenerów
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
