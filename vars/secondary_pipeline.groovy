def call(Map args = [:]) {
    pipeline {
        agent any
        stages {
            stage('Pipeline Two') {
                steps {
                    echo "Running Pipeline Two with arguments: ${args}"
                }
            }
        }
    }
}
