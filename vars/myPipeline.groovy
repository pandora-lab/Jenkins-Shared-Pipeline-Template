// vars/myPipeline.groovy
def call(Map config) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    echo 'Building...'
                   // sh 'mvn clean install' // Example build step
                }
            }
            stage('Test') {
                steps {
                    echo 'Running tests...'
                    // sh 'mvn test' // Example test step
                }
            }
            stage('Deploy') {
                steps {
                    echo 'Deploying...'
                    // Example deployment logic
                    if (config.env == 'production') {
                       // sh 'deploy-prod.sh'
                    } else {
                       // sh 'deploy-dev.sh'
                    }
                }
            }
        }
    }
}
