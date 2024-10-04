import groovy.yaml.YamlSlurper
def call() {
    echo "Hello Gents and ladies"
    // Load the YAML file
    def yamlFile = new File("${WORKSPACE}/Parse_Yaml/Devops/master_inventory.yml")
    def yamlContent = yamlFile.text

    // Parse the YAML
    def inventory = new YamlSlurper().parseText(yamlContent)

    // Iterate through the inventory and print details for 'dev' environment
    inventory.each { entry ->
        entry.CAMS.each { cam ->
            if (cam.env == 'dev') {
                cam.each { key, value ->
                    println "Name: ${value.name}, Port: ${value.port}, Path: ${value.path}"
                }
            }
        }
    }
}

