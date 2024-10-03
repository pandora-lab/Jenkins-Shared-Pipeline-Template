

def readInventoryYaml(filePath) {
    // def yaml = new Yaml()
    // def inventory = yaml.load(new File(filePath).text)

    def inventory = readYaml file: filePath

    def devServers = [:] // Initialize an empty map for dev environment

    // Iterate through the inventory and extract dev environment servers
    inventory.each { envConfig ->
        envConfig.each { envName, config ->
            if (config.env == 'dev') {
                config.each { key, server ->
                    if (key != 'env') { // Skip the 'env' entry
                        devServers[key] = [
                            name: server['name'], // Access properties directly
                            port: server['port'],
                            path: server['path']
                        ]
                    }
                }
            }
        }
    }

    return devServers
}

