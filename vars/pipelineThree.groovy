def call(Map args = [:]) {
    pipeline {
        agent any
        stages {
            stage('Call Pipeline One') {
                steps {
                    script {
                        pipelineOne(args.pipelineOne ?: [:])
                    }
                }
            }
            stage('Call Pipeline Two') {
                steps {
                    script {
                        pipelineTwo(args.pipelineTwo ?: [:])
                    }
                }
            }
        }
    }
}
