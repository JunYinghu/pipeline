properties(
[
parameters(
[
choice (choices:["stg","prd","dev"],description:"test env"  ,name:"testEnv"),
string (defaultValue:"Latest",description:"test version"  ,name:"testVersion"),
booleanParam(defaultValue: true, description:"test sign off generated" , name:"signOff")

]
)

]
)
pipeline {

  agent {label 'test'}

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
