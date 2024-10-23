def call(String name) {
    stage('Hello World') {
        // Directly place the script here without wrapping it in steps
        script {
            sh "python3 --version"
            sh "python3 ./helloworld.py"
        }
    }
}
