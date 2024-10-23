def call(String name) {
    stage('Hello World') {
        steps {
            script {
                // Print Python version
                sh "python3 --version"
                // Execute the Python script
                sh "python3 scripts/helloworld.py ${name}"
            }
        }
    }
}
