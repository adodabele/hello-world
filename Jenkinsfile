pipeline {
  agent any
  //tools {
    //gradle 'gradle'
 // }
  
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
        withGradle{
          echo 'executing gradle...' 
          sh './gradlew -v'
        }
      }
    }
  }
}
