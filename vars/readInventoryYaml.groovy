
def yamlFilePath = "$WORKSPACE/Parse_Yaml/Devops/master_inventory.yaml"
def serverMap
def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout Master inventory') {
                steps {
                    script {
                        echo 'Checking out the code...'
                        // Add your checkout logic here
                        serverMap = findServerDetails()
                    }
                }
            }
            stage('Checkout manifest file') {
                steps {
                    echo 'Building the project...'
                    // Add your build logic here
                    sh 'mvn clean package'
                }
            }
             // Uncomment and fill in the necessary logic for these stages
            /*
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
                        master_inventory[serverKey] = [
                            name: serverValue['name'], // Access properties using map-style
                            port: serverValue['port'],
                            path: serverValue['path']
                        ]
                    }
                }
            }
        }
    }
    master_inventory.each { println "$it.key: $it.value" }
    return master_inventory
}

def findServerDetails() {
    def serverDetails = [:]
    def manifestFilePath = "${WORKSPACE}/Parse_Yaml/manifest.yaml"
    def inventoryFilePath = "${WORKSPACE}/Parse_Yaml/Devops/master_inventory.yaml"
    def manifestYaml = readYaml file: manifestFilePath
    def inventoryYaml = readYaml file: inventoryFilePath

    manifestYaml.each { manifestKey, manifestValue ->
        inventoryYaml.each { apps ->
            println(apps)
            if (apps.containsKey(manifestValue.App)) {
                println('Inside 1st if loop')
                apps[manifestValue.App].each { appsKey, appsValue ->
                    if (manifestValue.Env == appsValue.env) {
                        println("Reached where i wanted tooo")
                    }
                }    
            }
        }
    }

    // // Iterate through the inventory to find details
    // inventory.each { entry ->
    //     if (entry.containsKey(app)) {
    //         entry[app].each { serverInfo ->
    //             if (serverInfo.env == env) {
    //                 servers.each { serverAlias ->
    //                     if (serverInfo.containsKey(serverAlias)) {
    //                         def server = serverInfo[serverAlias]
    //                         serverDetails[serverAlias] = [
    //                             name: server.name,
    //                             port: server.port,
    //                             path: server.path
    //                         ]
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }
    // return serverDetails
}
