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
// vars/pipelineStages.groovy
def buildStage() {
    stage('Build') {
        steps {
            echo 'Building the application...'
            // Add your build commands here
        }
    }
}

def testStage() {
    stage('Test') {
        steps {
            echo 'Running tests...'
            // Add your test commands here
        }
    }
}

def deployStage() {
    stage('Deploy') {
        steps {
            echo 'Deploying the application...'
            // Add your deployment commands here
        }
    }
}