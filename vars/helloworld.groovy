def call(String name) {
    stage('Hello World') {
        // Directly place the script here without wrapping it in steps
        script {
            echo "Hello ${name}"
        }
    }
}
