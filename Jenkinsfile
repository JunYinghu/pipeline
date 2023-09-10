pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn --version'
                sh 'mvn --test'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
