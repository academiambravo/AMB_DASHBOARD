pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('squ_3eb9cd856f53ccf2016ddb3553ad0527c6181752')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SONARQUBE_SERVER_NAME') {
                    sh "mvn sonar:sonar -Dsonar.login=$squ_3eb9cd856f53ccf2016ddb3553ad0527c6181752"
                }
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        // Aquí puedes añadir más stages, como deploy, solo en ramas específicas
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build or Quality Gate failed.'
        }
    }
}
