dev buildApp() {

  echo "Building the application"
}

dev testApp() {
  echo "Testing the application"
}

dev deployApp() {
  echo 'Deploying the application..."
  echo "deploying version ${params.VERSION}"
}

return this
