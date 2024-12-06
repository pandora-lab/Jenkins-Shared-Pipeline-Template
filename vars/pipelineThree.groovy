def call(Map args = [:]) {
    pipeline {
        agent any
        stages {
            stage('Run Pipeline One Stages') {
                steps {
                    script {
                        pipelineOneStages(args.pipelineOne ?: [:])
                    }
                }
            }
            stage('Run Pipeline Two Stages') {
                steps {
                    script {
                        pipelineTwoStages(args.pipelineTwo ?: [:])
                    }
                }
            }
        }
    }
}
