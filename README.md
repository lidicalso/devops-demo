# DevOps Demo

### Ambiente
Para ejecutar el entorno correctamente necesitas preparar un ambiente con las características:
Docker 1.9.1
Docker-compose 1.5.1

### Preparación
1) Copia todos los archivos del repositorio al entorno donde instalaste Docker y Docker compose.
2) Parado sobre la carpeta devops-demo (del repositorio), ejecuta los siguientes comandos
	Para descargar las imágenes necesarias de DockerHub.
	```
	# docker-compose pull
	```

	Para crear las imagenes necesarias desde sus respectivos docker files.
	```
	# docker-compose build
	```
3) Para ejecutar los containers de todos los servicios.
	```
	# docker-compose up -d
	```

	Para ver los logs de alguno de los containers en particular ejecutar:
	```
	# docker logs -f <container_name>
	```

## Links a las Tools

| *Tool* | *Link* | *Credentials* |
| ------------- | ------------- | ------------- |
| Jenkins | http://${docker-machine ip default}:18080/ | no login required |
| SonarQube | http://${docker-machine ip default}:19000/ | admin/admin |
| Nexus | http://${docker-machine ip default}:18081/nexus | admin/admin123 |
| GitLab | http://${docker-machine ip default}:10080/ | root/5iveL!fe |
| Selenium Grid | http://${docker-machine ip default}:4444/grid/console | no login required |


# --------------------------------------------------
# ---------------- OLD README TEXT -----------------
# --------------------------------------------------
# CI Tools Demo

This GitHub repository contains Dockerfiles for running a set of Continuous Integration Tools with a single command.
The diagram contains all tools used in the Docker containers.

![Docker CI Tools](screenshots/docker-ci-tools.png)

## Prerequisites (Mac)

You should have Docker Toolbox installed, see https://www.docker.com/toolbox

I am using docker-compose to start several docker container at once.
Since all containers run in a single VM (virtualbox), this VM needs enough memory.

### Step 0 - List Docker Machine

```
~/git/docker-ci-tool-stack$ docker-machine ls

NAME      ACTIVE   DRIVER       STATE     URL                         SWARM
default   *        virtualbox   Running   tcp://192.168.99.100:2376
```

### Step 1 - Stop your docker VM

```
docker-machine stop default
```

### Step 2 - Increase Memory via VirtualBox UI

I am using 6000MB for my VM.

![VirtualBox](screenshots/virtualbox.png)

### Step 3 - Start VM

```
docker-machine start default
```

## Getting started

To get all docker containers up and running use:

```
git clone git@github.com:marcelbirkner/docker-ci-tool-stack.git
cd docker-ci-tool-stack
docker-compose up
```

## Screenshots

Here is an overview of all tools:

- GitLab is used for storing the Sourcecode
- Jenkins contains build job and is triggered once projects in GitLab are updated
- As part of the CI build, Jenkins triggers a static code analysis and the results are stored in SonarQube
- The Maven build uses Nexus as a Proxy Repository for all 3rd party libs. The build artefacts are deployed to the Nexus Release Repository
- The Selenium Grid contains Docker containers running Chrome and Firefox and is used for UI tests

### Jenkins Jobs

There are several jobs preconfigured in Jenkins.
The Jobs cover the following tasks:

- Continuous Integration Build with Maven
- Unit Tests
- Static Source Analysis results are stored in SonarQube
- JaCoCo Test Coverage
- Deployment to Nexus
- Jenkins Job DSL examples
- Selenium UI Test

![Conference App Jobs](screenshots/jenkins-jobs-1.png)

![Conference App CI Job](screenshots/jenkins-jobs-2-conference-app-ci.png)

### SonarQube Dashboard

![Jenkins Jobs](screenshots/sonar-analysis-conference-app.png)

### Nexus Repository

![Nexus Proxy Repository](screenshots/nexus.png)

### Selenium Grid

![Selenium Grid](screenshots/selenium-grid.png)
