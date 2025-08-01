pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17' // Cambia versión si usas otra de Java
            args '-v $HOME/.m2:/root/.m2' // Cache local Maven
        }
    }

    environment {
        SONAR_TOKEN = credentials('squ_3eb9cd856f53ccf2016ddb3553ad0527c6181752') // Cambia el ID si el tuyo es otro
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
                withSonarQubeEnv('SonarQube') { // Usa el nombre que diste en Jenkins > Manage Jenkins > Configure System > SonarQube servers
                    sh "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN"
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
    }
    post {
        failure {
            echo 'Build or Quality Gate failed.'
        }
    }
}
