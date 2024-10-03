
def yamlFilePath = "./Devops/master_inventory.yaml"

def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    echo 'Checking out the code...'
                    // Add your checkout logic here
                    parseMasterInventory()
                }
            }

            // Uncomment and fill in the necessary logic for these stages
            /*
            stage('Build') {
                steps {
                    echo 'Building the project...'
                    // Add your build logic here
                    sh 'mvn clean package'
                }
            }

            stage('Test') {
                steps {
                    echo 'Running tests...'
                    // Add your testing logic here
                    sh 'mvn test'
                }
            }

            stage('Deploy') {
                steps {
                    echo 'Deploying the application...'
                    // Add your deployment logic here
                    // e.g., sh 'deploy_script.sh'
                }
            }
            */
        }

        post {
            always {
                echo 'Cleaning up...'
                // Clean up logic
            }
        }
    }
}

def parseMasterInventory() {
    // Read the YAML file content using the readYaml step
    sh "ls -alR"
    def master_inventory = [:]
    def yamlFilePath = "${WORKSPACE}/Parse_Yaml/Devops/master_inventory.yaml"
    def yaml = readYaml file: yamlFilePath

    // Extract and print servers with env: dev
    yaml.each { entry ->
        entry.each { key, value ->
            if (value.env == 'dev') {
                echo "Environment: ${value.env}"
                value.each { serverKey, serverValue ->
                    if (serverKey != 'env') {
                        echo "  Name: ${serverValue.name}"
                        echo "  Port: ${serverValue.port}"
                        echo "  Path: ${serverValue.path}"
                        master_inventory.addAll(
                            [
                                
                            ]
                        )
                    }
                }
            }
        }
    }
}