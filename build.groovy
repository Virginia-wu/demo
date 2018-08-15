node {
    def dockerImage
    def imageName = 'demo'
    def registryUrl = '47.106.222.76:5000'
    def httpRegistryUrl = 'http://'+registryUrl
    def maven = docker.image('maven:3-alpine')

    stage('checkout') {

        checkout scm
    }

    stage('MvnBuild') {

        maven.inside('-v /root/.m2/:/root/.m2/'){
            sh 'mvn -T 4 -P docker clean install '
        }
    }

    stage('BuildImage') {

        dockerImage = docker.build(imageName)
    }

    stage('PushImage') {

        docker.withRegistry(httpRegistryUrl) {

            dockerImage.push("t_$BUILD_NUMBER")
            dockerImage.push("latest")
        }
    }
}