def call(String name) {
    stages {
            stage('Hello World') {
                steps {
                    script {
                        echo "Hello ${name}"
                    }
            }
        }
    }
}