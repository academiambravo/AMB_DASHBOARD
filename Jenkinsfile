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
                withSonarQubeEnv('SonarQube') {
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
    // always {
    //     junit 'target/surefire-reports/*.xml'
    // }
    failure {
        echo 'Build or Quality Gate failed.'
    }
}

}
