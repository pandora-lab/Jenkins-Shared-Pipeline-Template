def call(String name) {
    stage('Hello World') {
        // Directly define the steps inside the stage
        steps {
            script {
                echo "Hello ${name}"
            }
        }
    }
}
