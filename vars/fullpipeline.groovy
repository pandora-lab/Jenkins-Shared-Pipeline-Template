// vars/myPipeline.groovy
def call() {
    return [
        stage('Build') {
            steps {
                echo 'Building...'
            }
        },
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        },
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    ]
}