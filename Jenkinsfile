pipeline {
  agent any
  
  tools {
      gradle 'Gradle' 
  }
  stages {
    stage("run frontend") {
      steps {
          echo 'executing yarn...'
          nodejs('Node-14.0'){
            sh 'yarn install'
          }
 
      }
    }
    stage("run backend") {
      steps {
          echo 'executing gradle...' 
             sh './gradle -v'
      }
    }
  }
}
