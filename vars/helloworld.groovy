def call(String name) {  
    stage('Hello World') { // Remove "stages" here since it's a single stage
        step {
            script {
                echo "Hello ${name}"
            }
        }
    }
}