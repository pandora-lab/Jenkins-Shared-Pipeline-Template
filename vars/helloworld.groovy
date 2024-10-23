def cal(String name) {
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