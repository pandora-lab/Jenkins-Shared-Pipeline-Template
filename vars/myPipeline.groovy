import groovy.yaml.YamlSlurper
def call() {
    // Load the YAML file
    def yamlFile = new File("../Parse_Yaml/Devops/master_inventory.yaml")
    def yamlContent = yamlFile.text

    // Parse the YAML
    def inventory = new YamlSlurper().parseText(yamlContent)

    // Iterate through the inventory and print details for 'dev' environment
    inventory.each { entry ->
        entry.each { key, value ->
            println("inside entry")
            if (value.env == 'dev') {
                println("inside if")
                if (key != 'env') {
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

call()

