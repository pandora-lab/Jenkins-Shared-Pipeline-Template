def call(Map args = [:]) {
    pipeline {
        agent any
        stages {
            stage('Pipeline One') {
                steps {
                    echo "Running Pipeline One with arguments: ${args}"
                }
            }
        }
    }
}
