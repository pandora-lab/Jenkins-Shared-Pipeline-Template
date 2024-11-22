def call() {
    pipeline {
        agent any
        stages {
            stage('DEPLOY FILES') {
                steps {
                    script {
                        echo "DEPLOYING FILES"
                    }
                }
            }
            stage('BUILD FILES') {
                steps {
                    script {
                        echo "BUILDING FILES"
                    }
                }
            }
            stage('COPY FILES') {
                steps {
                    script {
                        echo "BUILDING FILES"
                    }
                }
            }
        }
    }
    
}