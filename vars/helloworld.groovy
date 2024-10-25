def call(String name, String place) {
    stage('Hello World') {
            script {
                // Print Python version
                sh "python3 --version"
                // Execute the Python script
                // sh "python3 scripts/helloworld.py ${name}"
                loadPythonScript(name: 'helloworld.py', path: 'com/demo')

                sh "python3 ./helloworld.py --name=${name} --place=${place}"
            }
    }
}
