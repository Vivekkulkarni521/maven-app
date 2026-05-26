class MavenApp implements Serializable {

    def steps

    MavenApp(steps) {
        this.steps = steps
    }

    def build() {
        steps.echo "Building Maven application..."
        steps.sh "mvn clean package"
    }

    def test() {
        steps.echo "Running tests..."
        steps.sh "mvn test"
    }

    def deploy() {
        steps.echo "Deploying application..."
        steps.sh "echo Deployment Successful"
    }
}

pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Vivekkulkarni521/maven-app.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    def app = new MavenApp(this)
                    app.build()
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    def app = new MavenApp(this)
                    app.test()
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def app = new MavenApp(this)
                    app.deploy()
                }
            }
        }
    }

    post {

        success {
            echo 'Pipeline executed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}
