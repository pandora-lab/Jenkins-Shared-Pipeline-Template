def call(String repo_Url, String repo_Username, String repo_Password, String target_Artifact_Name) {
    println("cloning Repo")
    sh "curl -u repo_Username:repo_Password -O ${nexusUrl}"
    sh "ls -al"
}