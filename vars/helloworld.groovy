def call(String name) {
    stage('Hello World') {
        // Directly place the script here without wrapping it in steps
        script {
            sh "python3 --version"
            sh "ls -alR"
            sh "python3 Scripts/helloworld.py ${name}"
        }
    }
}
