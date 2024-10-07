myServers = [:]
// def environment= [
//         dev: [
//             cams: [[
//                         alias: "dev_cams_1",
//                         name: "server_dev_1",
//                         port: 8080,
//                         path: '/opt/jboss/instance1/web-app/app1.war'
//                     ],
//                     [
//                         alias: "dev_cams_2",
//                         name: 'server_dev_2',
//                         port: 8080,
//                         path: '/opt/jboss/instance2/web-app/app2.war'
//                     ]
//         ]],
//         qa: [
//             cams: [
//                 qa_cams_1: [
//                     name: 'server_qa_1',
//                     port: 8081,
//                     path: '/opt/jboss/instance1/web-app/app1.war'
//                 ],
//                 qa_cams_2: [
//                     name: 'server_qa_2',
//                     port: 8081,
//                     path: '/opt/jboss/instance2/web-app/app2.war'
//                 ]
//             ]
//         ],
//         prod: [
//             cams: [
//                 prd_cams_1: [
//                     name: 'server_prd_1',
//                     port: 8083,
//                     path: '/opt/jboss/instance1/web-app/app1.war'
//                 ]
//             ]
//         ]
//     ]

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
        ]
    ]
]



def manifest = [
    [Env: "dev", App: "cams", Servers: ["dev_cams_1", "dev_cams_2"]]
]

// manifest.each { appValues ->
//     if( appValues.Env == "dev" ) {
//         if(appValues.App == "cams" ) {
//             appValues.Servers.each { names ->
//                 println(names)
//             }
//         }
//     }
// }

manifest.each { manifestList ->
    environment.each { envKeys, envValues ->
        if( envKeys == manifestList.Env ) {
            println(" in dev")
            envValues.each { appKeys, appValues ->
                println(appKeys)
                if ( appKeys == manifestList.App ) {
                    println("In appKeys")
                    println(appValues)
                    // manifestList.Servers.each { serverAlias ->
                    //     println("in serverAlias")
                    //     println(serverAlias)
                    //     appValues.each { serverKey, serverValue ->
                    //         println(serverValue)
                    //         if( serverValue.alias in serverAlias ) {
                    //             println("Name : serverValue.name")
                    //             println("port : serverInfo.port")
                    //         }
                    //     }
                    // }
                    appValues.each { serverKey, serverValue ->
                        println("server value:")
                        println(serverValue)
                        if (serverValue.alias in manifestList.Servers) {
                            println("Found server: ${serverValue.alias}")
                            println("Name: ${serverValue.name}")
                            println("Port: ${serverValue.port}")
                        }
                    }


                }
            }
        }
    }
}


















// def myserver = [
//     CAMS: [
//         - [env: dev,
//           dev_cams_2: [
//             name: "server_dev_2",
//             port: 8080
//           ],
//           dev_cams_1: [
//             name: "server_dev_1",
//             port: 8081
//           ]]
//         - [env: qa,
//           qa_cams_2: [
//             name: "server_dev_2",
//             port: 8080
//           ],
//           qa_cams_1: [
//             name: "server_dev_1",
//             port: 8081
//           ]]
//     ],
//     AHS: [
//         - [env: dev,
//           dev_ahs_2: [
//             name: "server_dev_2",
//             port: 8080
//           ],
//           dev_ahs_1: [
//             name: "server_dev_1",
//             port: 8081
//           ]]
//         - [env: qa,
//           qa_ahs_2: [
//             name: "server_dev_2",
//             port: 8080
//           ],
//           qa_ahs_1: [
//             name: "server_dev_1",
//             port: 8081
//           ]]
//     ]
// ]

// myserver.each { entry -> println "Key : $entry.key" }