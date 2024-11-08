// vars/myPipeline.groovy
// def call() {
//     return [
//         stage('Build') {
//             steps {
//                 echo 'Building...'
//             }
//         },
//         stage('Test') {
//             steps {
//                 echo 'Testing...'
//             }
//         },
//         stage('Deploy') {
//             steps {
//                 echo 'Deploying...'
//             }
//         }
//     ]
// }
def call() {
    def stages = {
        stage('Build') {
            steps {
                echo 'Building the application...'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying to environment...'
            }
        }
    }
    return stages
}