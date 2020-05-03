//CODE_CHANGES = getGitChanges
//Adding groovy script and calling from Jenkinsfile
def gv
pipeline {
  agent any
  tools{
    //gradle maven jdk -> Jenkins provided tools
    //maven 'Maven'
    gradle 'gradle'
  }
  parameters {
    //string (name: 'VERSION', defaultValue: ' ', description: 'version to deploy to prod')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  environment {
    NEW_VERSION = '1.3.0' 
    SERVER_CREDENTIALS = credentials('server-credentials') 
  }

  stages {
    stage("init"){
      steps {
        script {
            gv = load "script.groovy"
        }
      }  
    }
    stage("build") {
        //when{
        //expression{
          //BRANCH_NAME == 'dev' || BRANCH_NAME == 'master' && CODE_CHANGES == true  
        //}
        //}
        steps {
        script {
            gv.buildApp()
        }
      }  
    }
    stage("test") {
      when {
        expression {
          params executeTests
        }
      }
      steps{
        script {
          gv.testApp()
        }
      }
    }

    stage("deploy") {

      steps {
        script {
          gv.deployApp()
        }

      }
    }
  }
  post{
    always {
      echo 'Inside post - always'
    }
    failure{
      echo 'Inside post - failure'
    }
  }
}
