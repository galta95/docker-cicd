pipelineJob('boilerplate-pipeline') {
    definition {
        cpsScm{
            scm{
                git{
                    remote{
                        url('git://github.com/galta95/docker-cicd.git')
                        }
                    }
                }
            scriptPath("./basics/misc/Jenkinsfile")
            }
        }
    }
