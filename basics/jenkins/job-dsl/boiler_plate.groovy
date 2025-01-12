pipelineJob('boilerplate-pipeline') {

    def repo = "https://github.com/galta95/docker-cicd.git"

    triggers {
        scm('H/5 * * * *')
    }
    description("Pipeline for repo")
    
    definition {
        cpsScm{
            scm{
                git{
                    remote{
                        url('git://github.com/galta95/docker-cicd.git')
                        branches('master') 
                        }
                    }
                }
            scriptPath("/basics/misc/Jenkinsfile")
            }
        }
    }
