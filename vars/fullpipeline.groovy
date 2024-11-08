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
def stages = []
stages << stage('Build') {
    steps { 
        echo 'Building the application...'
    }
}
stages << stage('Test') {
    steps { 
        echo 'Running tests...'
    }
}
stages << stage('Deploy') {
    steps { 
        echo 'Deploying to environment...'
    }
}

return stages