// If you are using shared libraries, replace with your library
import org.yaml.snakeyaml.Yaml

def readInventoryYaml(filePath) {
    def yaml = new Yaml()
    def inventory = yaml.load(new File(filePath).text)

    def serverMap = [:] // Initialize an empty map

    // Iterate through the inventory and populate the serverMap
    inventory.each { envConfig ->
        envConfig.each { envName, config ->
            config.each { key, server ->
                if (key != 'env') { // Skip the 'env' entry
                    serverMap[key] = [
                        name: server.name,
                        port: server.port,
                        path: server.path
                    ]
                }
            }
        }
    }

    return serverMap
}


