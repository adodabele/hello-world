def buildApp() {
  echo 'building the application...'
  echo "building version ${NEW_VERSION}"

}

def testApp() {
  echo "Testing the application"
}

def deployApp() {

  //echo "deploying with ${SERVER_CREDENTIALS}"
  //sh " ${SERVER_CREDENTIALS"
  //or
  //withCredentials([
    //usernamePassword(credentials: 'server-credentials', usernameVariable: USR, passwordVariable: PWD)
  //]){
    //sh "some script ${USER} ${PWD}"
    //echo 'getting credentials... ${USR} and ${PWD}'
  //}

  echo "Deploying the application..."
  echo "deploying version ${params.VERSION}"

}

return this
