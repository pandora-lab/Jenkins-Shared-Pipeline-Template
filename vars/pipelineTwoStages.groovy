def call(Map args = [:]) {
    stage('Pipeline Two - Step 1') {
        echo "Pipeline Two - Step 1 running with arguments: ${args}"
    }
    stage('Pipeline Two - Step 2') {
        echo "Pipeline Two - Step 2 running with arguments: ${args}"
    }
}
