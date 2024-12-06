def call(Map args = [:]) {
    stage('Pipeline One - Step 1') {
        echo "Pipeline One - Step 1 running with arguments: ${args}"
    }
    stage('Pipeline One - Step 2') {
        echo "Pipeline One - Step 2 running with arguments: ${args}"
    }
}
