node {
    def dockerImage
    def imageName = 'demo'
    def serviceName = 'demo'
    def registryUrl = 'registry.virginia.com:5000'
    def httpRegistryUrl = 'http://'+registryUrl
    def maven = docker.image('maven:3-alpine')

    def testResult

    stage('checkout') {

        checkout scm
    }

    stage('JaCoCo Report') {
        def result = jacoco(execPattern: '**/target/jacoco.exec')
        testResult = result
    }

    stage('email') {
        emailext body: testResult, subject: "jacoco报告", to: 'wujiayunny@163.com'

    }

//    stage('MvnBuild') {
//
//        maven.inside('-v /root/.m2/:/root/.m2/'){
//            sh 'mvn -T 4 -P docker clean install '
//        }
//    }
//
//    stage('BuildImage') {
//
//        dockerImage = docker.build(imageName)
//    }
//
//    stage('PushImage') {
//
//        docker.withRegistry(httpRegistryUrl) {
//
//            dockerImage.push("t_$BUILD_NUMBER")
//            dockerImage.push("latest")
//        }
//    }
//    stage('AppDeploy') {
//
//        sh  'docker service update --update-order start-first --image '+registryUrl+'/'+imageName+":t_$BUILD_NUMBER  stack_"+serviceName
//    }


}