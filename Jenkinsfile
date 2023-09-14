
pipeline {

  agent {label 'Jenkins'}

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn --version'
                sh 'mvn clean package -f pom.xml'
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
