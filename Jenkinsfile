//CODE_CHANGES = getGitChanges
pipeline {
  agent any
  tools{
    //gradle maven jdk -> Jenkins provided tools
    //maven 'Maven'
    gradle 'gradle'
  }
  parameters {
    string (name: 'VERSION', defaultValue: ' ', description: 'version to deploy to prod')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
    
    
  }
  environment {
    NEW_VERSION = '1.3.0' 
    SERVER_CREDENTIALS = credentials('server-credentials') 
    
  }
  stages {
    stage("build") {
        //when{
        //expression{
          //BRANCH_NAME == 'dev' && CODE_CHANGES == true  
        //}
        //}
      steps {
          echo 'building the application...'
        echo "building version ${NEW_VERSION}"
      }
    }
    stage("test") {
      when{
        expression{
          BRANCH_NAME == 'dev' || BRANCH_NAME == 'master' 
        }
      }
      steps {
          echo 'testing the application...'
      }
    }
    stage("deploy") {
      steps {
          echo 'deploying the application...'
          //echo "deploying with ${SERVER_CREDENTIALS}"
          //sh " ${SERVER_CREDENTIALS"
          //or
          withCredentials([
            usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
          ]){
            //sh "some script ${USER} ${PWD}"
            echo 'getting credentials... ${USER} and ${PWD}'
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
