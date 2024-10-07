def environment = [
    dev: [
        cams: [
            [
                alias: "dev_cams_1",
                name: "server_dev_1",
                port: 8080,
                path: '/opt/jboss/instance1/web-app/app1.war'
            ],
            [
                alias: "dev_cams_2",
                name: "server_dev_2",
                port: 8080,
                path: '/opt/jboss/instance2/web-app/app2.war'
            ]
        ],
        ahs: [
            [
                alias: "dev_ahs_1",
                name: "server_ahs_1",
                port: 8089,
                path: '/opt/jboss/instance1/web-app/app1.war'
            ],
            [
                alias: "dev_ahs_2",
                name: "server_ahs_2",
                port: 8088,
                path: '/opt/jboss/instance2/web-app/app2.war'
            ]
        ]
    ],
    qa: [
        cams: [
            [
                alias: "qa_cams_1",
                name: "server_qa_1",
                port: 8081,
                path: '/opt/jboss/instance1/web-app/app1.war'
            ],
            [
                alias: "qa_cams_2",
                name: "server_qa_2",
                port: 8081,
                path: '/opt/jboss/instance2/web-app/app2.war'
            ]
        ]
    ],
    prod: [
        cams: [
            [
                alias: "prd_cams_1",
                name: "server_prd_1",
                port: 8083,
                path: '/opt/jboss/instance1/web-app/app1.war'
            ]
        ]
    ]
]

def manifest = [
    [Env: "dev", App: "cams", Servers: ["dev_cams_1", "dev_cams_2"]],
    [Env: "dev", App: "ahs", Servers: ["dev_ahs_1", "dev_ahs_2"]]
]

manifest.each { manifestList ->
    environment.each { envKey, envValue ->
        if (envKey == manifestList.Env) {
            println("In environment: ${envKey}")
            def appList = envValue[manifestList.App] // Get the corresponding app list

            appList.each { app ->
                if (app.alias in manifestList.Servers) {
                    println("Found server: ${app.alias}")
                    println("Name: ${app.name}")
                    println("Port: ${app.port}")
                }
            }
        }
    }
}
