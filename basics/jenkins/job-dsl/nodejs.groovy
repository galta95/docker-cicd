job('NodeJS example') {
    scm {
        git('git://github.com/galta95/docker-cicd.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('node_11') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}

job('NodeJS Docker example') {
    scm {
        git('git://github.com/galta95/docker-cicd.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('node_11') 
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('galta99') //qa / dev
            tag('${GIT_REVISION,length=9}')
            registryCredentials('galt99')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}