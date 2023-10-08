properties(
[
parameters(
[
choice (choices:["stg","prd","dev"],description:"test env"  ,name:"testEnv"),
string (defaultValue:"",description:"create test cycle if given"  ,name:"testCycle"),
booleanParam (defaultValue:true,description:"enabling priorTest api ",name:"enablePriorTestApi"),
string (defaultValue:"Latest",description:"test version"  ,name:"testVersion"),
booleanParam(defaultValue: true, description:"test sign off generated" , name:"signOff")

]
)

]
)
pipeline {

  agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn --version'
                sh 'mvn clean'

            }
        }
        stage('Test') {
            steps {
                  sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
